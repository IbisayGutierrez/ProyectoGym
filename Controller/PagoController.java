/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Modelo.Pago.Pago;
import Modelo.Pago.PagoDAO;
import Modelo.Pago.PagoDTO;
import Modelo.Pago.PagoMapper;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Dell
 */
public class PagoController {
    private PagoDAO pagoDAO;
    private PagoMapper pagoMapper;

   public PagoController(Connection connection) {
        this.pagoDAO = new PagoDAO(connection);  // Inicializa el DAO de Pago
        this.pagoMapper = new PagoMapper();  // Inicializa el Mapper
    }

    // Crear un nuevo pago
    public boolean crearPago(Pago pago) throws SQLException {
        if (pago == null || !isPagoValido(pago)) {
            return false;
        }
        
        // Realizar los cálculos de subtotal, impuesto y total
        double subtotal = calcularSubtotal(pago);
        double impuesto = calcularImpuesto(subtotal);
        double total = subtotal + impuesto;

        // Asignar los valores calculados al objeto Pago
        pago.setSubtotal(subtotal);
        pago.setImpuesto(impuesto);
        pago.setTotal(total);

        // Convertir la entidad Pago a su DTO para ser persistida
        PagoDTO pagoDTO = pagoMapper.toDTO(pago);
        return pagoDAO.create(pagoDTO);
    }

    // Obtener un pago por su ID
    public Pago obtenerPagoPorId(int idPago) throws SQLException {
        PagoDTO pagoDTO = pagoDAO.read(idPago);
        return pagoMapper.toEnt(pagoDTO);  // Convertir de DTO a entidad
    }

    // Obtener todos los pagos
    public List<Pago> obtenerTodosLosPagos() throws SQLException {
        List<PagoDTO> pagosDTO = pagoDAO.readAll();
        List<Pago> pagos = new ArrayList<>();
        
        for (PagoDTO dto : pagosDTO) {
            pagos.add(pagoMapper.toEnt(dto));  // Convertir cada DTO a entidad
        }
        return pagos;
    }

    // Eliminar un pago por su ID
    public boolean eliminarPago(int idPago) throws SQLException {
        return pagoDAO.delete(idPago);
    }

    // Validar si un pago es válido (puedes agregar más validaciones si lo necesitas)
    private boolean isPagoValido(Pago pago) {
        return pago.getSubtotal() > 0 && pago.getImpuesto() >= 0 && pago.getTotal() == pago.CalcularTotal();
    }

    // Calcular el subtotal basado en el tipo de membresía
    private double calcularSubtotal(Pago pago) {
        double subtotal = 0.0;
        
        // Lógica para calcular el subtotal según la membresía del cliente
        String tipoMembresia = pago.getCliente().getTipoMembresia();
        switch (tipoMembresia) {
            case "Básica":
                subtotal = 15000; // Membresía Básica
                break;
            case "Plus":
                subtotal = 25000; // Membresía Plus
                break;
            case "Platino":
                subtotal = 35000; // Membresía Platino
                break;
            case "Diamante":
                subtotal = 45000; // Membresía Diamante
                break;
            default:
                // Si no se reconoce el tipo de membresía, establecer un valor por defecto o lanzar excepción
                throw new IllegalArgumentException("Tipo de membresía no válido: " + tipoMembresia);
        }
        
        return subtotal;
    }

    // Calcular el impuesto (por ejemplo, un 16%)
    private double calcularImpuesto(double subtotal) {
        double impuesto = 0.16; // 16% de impuesto
        return subtotal * impuesto;
    }
}