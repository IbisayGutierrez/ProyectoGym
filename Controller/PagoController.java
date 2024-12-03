/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import DataBase.DataBase;
import Modelo.Pago.Pago;
import Modelo.Pago.PagoDAO;
import Modelo.Pago.PagoDTO;
import Modelo.Pago.PagoMapper;
import View.View;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
/**
 *
 * @author Dell
 */
public class PagoController {
    private PagoDAO pagoDAO;
    private PagoMapper pagoMapper;
    private final View view;             
    private static final double IMPUESTO_PORCENTAJE = 0.16; // 16% de impuestos
    private static final String[] TIPOS_MEMBRESIA = {"básico", "plus", "platino", "diamante"};
    private static final double[] COSTOS_MEMBRESIA = {15000, 25000, 35000, 45000};

    public PagoController(View view) {
        this.view = view;
        this.pagoMapper = new PagoMapper();
        try {
            this.pagoDAO = new PagoDAO(DataBase.getConnection()); // Conexión a BD
        } catch (SQLException ex) {
            view.showError("Error al conectar con la base de datos: " + ex.getMessage());
            throw new RuntimeException("No se pudo inicializar el controlador PagoController");
        } catch (ClassNotFoundException ex) {
            view.showError("Error en la configuración de la conexión a la base de datos.");
            throw new RuntimeException("No se pudo inicializar el controlador PagoController");
        }
    }

    // Crear un nuevo pago con cálculo de subtotal, impuesto y total
    public boolean crearPago(Pago pago) {
        if (pago == null || pago.getCliente() == null) {
            view.showError("Datos del pago o cliente incompletos.");
            return false;
        }

        // Obtener el tipo de membresía y validar
        String tipoMembresia = pago.getCliente().getTipoMembresia();
        if (!validarMembresia(tipoMembresia)) {
            view.showError("Tipo de membresía no válido: " + tipoMembresia);
            return false;
        }

        // Calcular los valores del pago
        double subtotal = obtenerCostoMembresia(tipoMembresia);
        double impuesto = subtotal * IMPUESTO_PORCENTAJE;
        double total = subtotal + impuesto;

        // Asignar los valores calculados al objeto Pago
        pago.setSubtotal(subtotal);
        pago.setImpuesto(impuesto);
        pago.setTotal(total);

        try {
            // Convertir a DTO y guardar en la base de datos
            PagoDTO dto = pagoMapper.toDTO(pago);
            if (pagoDAO.create(dto)) {
                view.showMessage("Pago registrado exitosamente. Total: $" + total);
                return true;
            } else {
                view.showError("No se pudo registrar el pago.");
                return false;
            }
        } catch (SQLException ex) {
            view.showError("Error al guardar el pago: " + ex.getMessage());
            return false;
        }
    }

    // Obtener un pago por su ID
    public Pago obtenerPago(int idPago) {
        try {
            PagoDTO dto = pagoDAO.read(idPago);
            if (dto == null) {
                view.showError("No se encontró un pago con el ID especificado.");
                return null;
            }
            return pagoMapper.toEnt(dto);
        } catch (SQLException ex) {
            view.showError("Error al obtener el pago: " + ex.getMessage());
            return null;
        }
    }

    

    // Eliminar un pago por su ID
    public boolean eliminarPago(int idPago) {
        try {
            if (pagoDAO.delete(idPago)) {
                view.showMessage("Pago eliminado correctamente.");
                return true;
            } else {
                view.showError("No se pudo eliminar el pago.");
                return false;
            }
        } catch (SQLException ex) {
            view.showError("Error al eliminar el pago: " + ex.getMessage());
            return false;
        }
    }

    // Obtener todos los pagos
    public List<Pago> listarPagos() {
        try {
            List<PagoDTO> dtos = pagoDAO.readAll();
           return dtos.stream()
    .map(dto -> {
        try {
            return pagoMapper.toEnt(dto);
        } catch (SQLException e) {
            throw new RuntimeException("Error al mapear PagoDTO a Pago", e);
        }
    })
    .collect(Collectors.toList());
        } catch (SQLException ex) {
            view.showError("Error al cargar los pagos: " + ex.getMessage());
            return new ArrayList<>();
        }
    }

    // Método para obtener el costo de la membresía según el tipo
    private double obtenerCostoMembresia(String tipoMembresia) {
        for (int i = 0; i < TIPOS_MEMBRESIA.length; i++) {
            if (TIPOS_MEMBRESIA[i].equalsIgnoreCase(tipoMembresia)) {
                return COSTOS_MEMBRESIA[i];
            }
        }
        return 0;
    }

    // Validar si el tipo de membresía es válido
    private boolean validarMembresia(String tipoMembresia) {
        for (String tipo : TIPOS_MEMBRESIA) {
            if (tipo.equalsIgnoreCase(tipoMembresia)) {
                return true;
            }
        }
        return false;
    }

    // Validar los datos de un pago
    private boolean validarPago(Pago pago) {
        return pago.getSubtotal() > 0 && pago.getImpuesto() >= 0 && pago.getTotal() == pago.CalcularTotal();
    }
}