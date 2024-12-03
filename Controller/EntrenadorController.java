/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Modelo.Entrenador.Entrenador;
import Modelo.Entrenador.EntrenadorDAO;
import Modelo.Entrenador.EntrenadorDTO;
import Modelo.Entrenador.EntrenadorMapper;
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
public class EntrenadorController {
    private final EntrenadorDAO entrenadorDAO;
    private final EntrenadorMapper entrenadorMapper;
    private final View view; 

    public EntrenadorController(View view, Connection connection) {
        this.view = view;
        this.entrenadorDAO = new EntrenadorDAO(connection); // Conexión inyectada
        this.entrenadorMapper = new EntrenadorMapper();

    }

    public void agregarEntrenador(Entrenador entrenador) {
        if (entrenador == null || !validarEntrenador(entrenador)) {
            view.showError("Datos del entrenador no válidos o nulos.");
            return;
        }

        try {
            EntrenadorDTO dto = entrenadorMapper.toDTO(entrenador);
            entrenadorDAO.create(dto);
            view.showMessage("Entrenador agregado correctamente.");
        } catch (SQLException e) {
            view.showError("Ocurrió un error al guardar los datos: " + e.getMessage());

        }

    }


    public Entrenador obtenerEntrenador(int id) {
        try {
            EntrenadorDTO dto = entrenadorDAO.read(id);
            return entrenadorMapper.toEnt(dto);
        } catch (SQLException e) {
            view.showError("Error al obtener el entrenador: " + e.getMessage());
            return null;
        }

    }

    public void actualizarEntrenador(Entrenador entrenador) {
        if (entrenador == null || !validarEntrenador(entrenador)) {
            view.showError("Datos del entrenador no válidos o nulos.");
            return;
        }
        try {
            entrenadorDAO.update(entrenadorMapper.toDTO(entrenador));
            view.showMessage("Entrenador actualizado correctamente.");
        } catch (SQLException e) {
            view.showError("Ocurrió un error al actualizar los datos: " + e.getMessage());
        }

    }

    public void eliminarEntrenador(int id) {
        try {
            if (validatePK(id)) {
                view.showError("El ID ingresado no se encuentra registrado.");
                return;
            }
            entrenadorDAO.delete(id);
            view.showMessage("Entrenador eliminado correctamente.");
        } catch (SQLException e) {
            view.showError("Ocurrió un error al eliminar los datos: " + e.getMessage());

        }

    }

    public List<Entrenador> listarEntrenadores() {
        try {
            List<EntrenadorDTO> dtoList = entrenadorDAO.readAll();
            return dtoList.stream()
                .map(dto -> {
                    try {
                        return entrenadorMapper.toEnt(dto);
                    } catch (Exception e) {
                        throw new RuntimeException("Error al mapear EntrenadorDTO a Entrenador", e);
                    }
                })

                .filter(Objects::nonNull) // Filtra los objetos nulos
                .collect(Collectors.toList());
        } catch (SQLException e) {
            view.showError("Error al cargar los datos: " + e.getMessage());
            return new ArrayList<>(); // Retorna una lista vacía en caso de error

        }

    }


    private boolean validarEntrenador(Entrenador entrenador) {
        // Aquí puedes agregar validaciones específicas para el entrenador
        return !entrenador.getNombre().trim().isEmpty() && 
               !entrenador.getContacto().trim().isEmpty() && 
               !entrenador.getEspecialidades().isEmpty(); // Ejemplo de validación
    }

    public boolean validatePK(int id) {
        try {
            return entrenadorDAO.validatePK(id);
        } catch (SQLException ex) {
            return false;
        }

    }

}

