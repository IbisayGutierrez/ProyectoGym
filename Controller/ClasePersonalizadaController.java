/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.ClasePersonalizada.ClasePersonalizada;
import Modelo.ClasePersonalizada.ClasePersonalizadaDAO;
import Modelo.ClasePersonalizada.ClasePersonalizadaDTO;
import Modelo.ClasePersonalizada.ClasePersonalizadaMapper;
import View.View;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ClasePersonalizadaController {
    private final ClasePersonalizadaDAO clasePersonalizadaDAO;
    private final ClasePersonalizadaMapper clasePersonalizadaMapper;
    private final View view;
    
    


    public ClasePersonalizadaController(View view, Connection connection) {
        this.view = view;
        this.clasePersonalizadaDAO = new ClasePersonalizadaDAO(connection); // Conexión inyectada
        this.clasePersonalizadaMapper = new ClasePersonalizadaMapper();
    }

    public void agregarClasePersonalizada(ClasePersonalizada clase) {
       
    if (clase == null || !validarClasePersonalizada(clase)) {
        view.showError("Datos de la clase no válidos o nulos.");
        return;
    }

    try {
        if (validatePK(clase.getId())) {
            view.showError("El ID de la clase personalizada ya existe.");
            return;
        }
        ClasePersonalizadaDTO dto = clasePersonalizadaMapper.toDTO(clase);
        clasePersonalizadaDAO.create(dto);
        view.showMessage("Clase personalizada agregada correctamente.");
    } catch (SQLException e) {
        view.showError("Ocurrió un error al guardar los datos: " + e.getMessage());
    }
}


    public ClasePersonalizada obtenerClasePersonalizada(int id) {
        
    try {
        if (!validatePK(id)) {
            view.showError("El ID ingresado no se encuentra registrado.");
            return null;
        }
        ClasePersonalizadaDTO dto = clasePersonalizadaDAO.read(id);
        return clasePersonalizadaMapper.toEnt(dto);
    } catch (SQLException e) {
        view.showError("Error al obtener la clase personalizada: " + e.getMessage());
        return null;
    }
}
       
    public void actualizarClasePersonalizada(ClasePersonalizada clase) {
       
    if (clase == null || !validarClasePersonalizada(clase)) {
        view.showError("Datos de la clase no válidos o nulos.");
        return;
    }

    try {
        if (!validatePK(clase.getId())) {
            view.showError("El ID de la clase personalizada no existe en la base de datos.");
            return;
        }
        clasePersonalizadaDAO.update(clasePersonalizadaMapper.toDTO(clase));
        view.showMessage("Clase personalizada actualizada correctamente.");
    } catch (SQLException e) {
        view.showError("Ocurrió un error al actualizar los datos: " + e.getMessage());
    }
}

public void eliminarClasePersonalizada(int id) {
    try {
        if (!validatePK(id)) {
            view.showError("El ID ingresado no se encuentra registrado.");
            return;
        }
        clasePersonalizadaDAO.delete(id);
        view.showMessage("Clase personalizada eliminada correctamente.");
    } catch (SQLException e) {
        view.showError("Ocurrió un error al eliminar los datos: " + e.getMessage());
    }
    }
    
        
       
    

    public List<ClasePersonalizada> listarClasesPersonalizadas() {
       
    try {
        // Obtener todas las clases personalizadas desde la base de datos
        List<ClasePersonalizadaDTO> dtoList = clasePersonalizadaDAO.readAll();
        
        // Mapear los DTO a las entidades
        List<ClasePersonalizada> clases = dtoList.stream()
                .map(dto -> {
                    try {
                        return clasePersonalizadaMapper.toEnt(dto);
                    } catch (Exception e) {
                        throw new RuntimeException("Error al mapear ClasePersonalizadaDTO a ClasePersonalizada", e);
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        
        // Aquí usas showAll para pasar la lista de clases a la vista
        view.showAll(clases); // Este método lo debe tener la vista para mostrar los elementos

        return clases;
    } catch (SQLException e) {
        view.showError("Error al cargar los datos: " + e.getMessage());
        return new ArrayList<>();
    }
}


    private boolean validarClasePersonalizada(ClasePersonalizada clase) {
        // Validaciones específicas para clases personalizadas
        return !clase.getTipoClase().trim().isEmpty() &&
               clase.getHorario() != null &&
               clase.getEntrenadorAsignado() != null &&
               clase.getCapacidadMaxima() > 0;
    }

    public boolean validatePK(int id) {
        try {
            return clasePersonalizadaDAO.validatePK(id);
        } catch (SQLException ex) {
            return false;
        }
    }
}

