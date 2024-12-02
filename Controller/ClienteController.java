/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Modelo.Cliente.Cliente;
import Modelo.Cliente.ClienteDAO;
import Modelo.Cliente.ClienteDTO;
import Modelo.Cliente.ClienteMapper;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class ClienteController {
     private final ClienteDAO clienteDAO;
    private final ClienteMapper clienteMapper;
    private static final String[] TIPOS_MEMBRESIA = {"básico", "plus", "platino", "diamante"};

    public ClienteController(Connection connection) {
        this.clienteDAO = new ClienteDAO(connection);
        this.clienteMapper = new ClienteMapper();
    }

    public boolean agregarCliente(Cliente cliente) {

        if (!validarMembresia(cliente.getTipoMembresia())) {

            System.out.println("Tipo de membresía no válido.");

            return false;
        }
        try {
            ClienteDTO dto = clienteMapper.toDTO(cliente);
            return clienteDAO.create(dto);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Cliente obtenerCliente(int id) {
        try {
            ClienteDTO dto = clienteDAO.read(id);
            return clienteMapper.toEnt(dto);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public boolean actualizarCliente(Cliente cliente) {
        if (!validarMembresia(cliente.getTipoMembresia())) {
            System.out.println("Tipo de membresía no válido.");
            return false;
        }
        try {
            ClienteDTO dto = clienteMapper.toDTO(cliente);
            return clienteDAO.update(dto);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarCliente(int id) {
        try {
            return clienteDAO.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


   public List<Cliente> listarClientes() {
    List<Cliente> clientes = new ArrayList<>();
    try {
        List<ClienteDTO> dtos = clienteDAO.readAll();
        for (ClienteDTO dto : dtos) {
            clientes.add(clienteMapper.toEnt(dto));
        }
    } catch (SQLException e) {
        e.printStackTrace();
       
    }
    return clientes;
}
    // Método para validar el tipo de membresía
    private boolean validarMembresia(String tipoMembresia) {
        for (String tipo : TIPOS_MEMBRESIA) {
            if (tipo.equalsIgnoreCase(tipoMembresia)) {
               return true;
            }
        }
        return false;
    }
}