/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Modelo.Cliente.Cliente;
import Modelo.Cliente.ClienteDAO;
import Modelo.Cliente.ClienteDTO;
import Modelo.Cliente.ClienteMapper;
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
public class ClienteController {
    private final ClienteDAO clienteDAO;
    private final ClienteMapper clienteMapper;
    private final View view; 
    private static final String[] TIPOS_MEMBRESIA = {"básico", "plus", "platino", "diamante"};

    public ClienteController(View view, Connection connection) {
        this.view = view;
        this.clienteDAO = new ClienteDAO(connection);
        this.clienteMapper = new ClienteMapper();
    }

    public void agregarCliente(Cliente cliente) {
        if (cliente == null || !validarMembresia(cliente.getTipoMembresia())) {
            view.showError("Tipo de membresía no válido o cliente nulo.");
            return;
        }
        try {
            if (!validatePK(cliente.getId())) {
                view.showError("La cédula ingresada ya se encuentra registrada.");
                return;
            }
            ClienteDTO dto = clienteMapper.toDTO(cliente);
            clienteDAO.create(dto);
            view.showMessage("Cliente agregado correctamente.");
        } catch (SQLException e) {
            view.showError("Ocurrió un error al guardar los datos: " + e.getMessage());
        }
    }

    public Cliente obtenerCliente(int id) {
        try {
            ClienteDTO dto = clienteDAO.read(id);
            return clienteMapper.toEnt(dto);
        } catch (SQLException e) {
            view.showError("Error al obtener el cliente: " + e.getMessage());
            return null;
        }
    }

    public void actualizarCliente(Cliente cliente) {
        if (cliente == null || !validarMembresia(cliente.getTipoMembresia())) {
            view.showError("Tipo de membresía no válido o cliente nulo.");
            return;
        }
        try {
            if (validatePK(cliente.getId())) {
                view.showError("La cédula ingresada no se encuentra registrada.");
                return;
            }
            clienteDAO.update(clienteMapper.toDTO(cliente));
            view.showMessage("Cliente actualizado correctamente.");
        } catch (SQLException e) {
            view.showError("Ocurrió un error al actualizar los datos: " + e.getMessage());
        }
    }

    public void eliminarCliente(int id) {
        try {
            if (validatePK(id)) {
                view.showError("La cédula ingresada no se encuentra registrada.");
                return;
            }
            clienteDAO.delete(id);
            view.showMessage("Cliente eliminado correctamente.");
        } catch (SQLException e) {
            view.showError("Ocurrió un error al eliminar los datos: " + e.getMessage());
        }
    }

   public List<Cliente> listarClientes() {
    try {
        List<ClienteDTO> dtoList = clienteDAO.readAll();
        return dtoList.stream()
            .map(dto -> {
                try {
                    return clienteMapper.toEnt(dto);
                } catch (Exception e) { // Captura cualquier excepción que pueda surgir
                    throw new RuntimeException("Error al mapear ClienteDTO a Cliente", e);
                }
            })
            .filter(Objects::nonNull) // Filtra los objetos nulos
            .collect(Collectors.toList());
    } catch (SQLException e) {
        view.showError("Error al cargar los datos: " + e.getMessage());
        return new ArrayList<>(); // Retorna una lista vacía en caso de error
    }
}

    private boolean validarMembresia(String tipoMembresia) {
        for (String tipo : TIPOS_MEMBRESIA) {
            if (tipo.equalsIgnoreCase(tipoMembresia)) {
                return true;
            }
        }
        return false;
    }

    public boolean validatePK(int id) {
        try {
            return clienteDAO.validatePK(id);
        } catch (SQLException ex) {
           return false;
        }
    }
}