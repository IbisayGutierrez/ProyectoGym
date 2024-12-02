/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Modelo.Entrenador.Entrenador;
import Modelo.Entrenador.EntrenadorDAO;
import Modelo.Entrenador.EntrenadorDTO;
import Modelo.Entrenador.EntrenadorMapper;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Dell
 */
public class EntrenadorController {
    private final EntrenadorDAO entrenadorDAO;
    private final EntrenadorMapper entrenadorMapper;
    
    public EntrenadorController(Connection connection) {
        this.entrenadorDAO = new EntrenadorDAO(connection); // Conexión inyectada
        this.entrenadorMapper = new EntrenadorMapper();
    }

    public boolean agregarEntrenador(Entrenador entrenador) {
        try {
            EntrenadorDTO dto = entrenadorMapper.toDTO(entrenador);
            return entrenadorDAO.create(dto);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Entrenador obtenerEntrenador(int id) {
        try {
            EntrenadorDTO dto = entrenadorDAO.read(id);
            return entrenadorMapper.toEnt(dto);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean actualizarEntrenador(Entrenador entrenador) {
        try {
            EntrenadorDTO dto = entrenadorMapper.toDTO(entrenador);
            return entrenadorDAO.update(dto);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarEntrenador(int id) {
        try {
            return entrenadorDAO.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    // Método para listar todos los entrenadores

    public List<Entrenador> listarEntrenadores() {
    List<Entrenador> entrenadores = new ArrayList<>();
    try {
        List<EntrenadorDTO> dtos = entrenadorDAO.readAll();
        for (EntrenadorDTO dto : dtos) {
            entrenadores.add(entrenadorMapper.toEnt(dto));
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Manejar errores aquí
    }
    return entrenadores;
}
    }

