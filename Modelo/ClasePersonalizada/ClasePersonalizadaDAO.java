/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.ClasePersonalizada;

import DataBase.DataBase;
import Modelo.Dao.DaoCRUD;
import Modelo.Entrenador.Entrenador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andre
 */
public class ClasePersonalizadaDAO extends DaoCRUD<ClasePersonalizadaDTO> {
    
    public ClasePersonalizadaDAO(Connection connection) {
        super(connection);
    }  
    
    @Override
    public boolean create(ClasePersonalizadaDTO dto) throws SQLException {
         if (dto == null || !validatePK(dto.getId())) {
            return false;
        }
        String query = "Call ClasePerzonnalizadaCreate(?,?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, dto.getId());
            stmt.setString(2, dto.getTipoClase());
            stmt.setString(3, dto.getHorario());
            stmt.setInt(4, dto.getEntrenadorAsignado().getId());
            stmt.setInt(5, dto.getCapacidadMaxima());
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public ClasePersonalizadaDTO read(Object id) throws SQLException {
          if (id == null || String.valueOf(id).trim().isEmpty()) {
        return null;
    }
    String query = "Call ClasePersonalizadaRead(?)";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setInt(1, (Integer) id); 
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                Entrenador entrenador = new Entrenador(); 
                entrenador.setId(rs.getInt(4)); 

                return new ClasePersonalizadaDTO(
                        rs.getInt(1), 
                        rs.getString(2),
                        rs.getString(3), 
                        entrenador, 
                        rs.getInt(5) 
                );
            }
        }
    }
    return null;

    }

    @Override
    public boolean update(ClasePersonalizadaDTO dto) throws SQLException {
          if (dto == null) {
            return false;
        }
        String query = "Call ClasePersonalizadaUpdate(?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, dto.getId());
            stmt.setString(2, dto.getHorario());
            stmt.setString(3, dto.getTipoClase());
            return stmt.executeUpdate() > 0;

        }

    }

    @Override
    public boolean delete(Object id) throws SQLException {
         if (id == null || String.valueOf(id).trim().isEmpty()) {
            return false;
        }
        String query = "Call ClasePersonalizadaDelete(?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, String.valueOf(id));
            return stmt.executeUpdate() > 0;

        }
    }
    
 public List<ClasePersonalizadaDTO> readAll() throws SQLException {
    PreparedStatement stmt = connection.prepareStatement("CALL ClasePersonalizadaReadAll()");  // Llamada al procedimiento almacenado para obtener todas las clases personalizadas
    ResultSet rs = stmt.executeQuery();
    List<ClasePersonalizadaDTO> dtos = new ArrayList<>();

    while (rs.next()) {
        Entrenador entrenador = new Entrenador();
        entrenador.setId(rs.getInt(4));  

        dtos.add(new ClasePersonalizadaDTO(
            rs.getInt(1),        
            rs.getString(2),     
            rs.getString(3),     
            entrenador,          
            rs.getInt(5)         
        ));
    }

    return dtos;
}
    
    public boolean validatePK(Object id) throws SQLException {
        return read(id) == null;
    }
   // Método para insertar una clase personalizada en la base de datos
    public static boolean insertarClasePersonalizada(ClasePersonalizada clase) throws SQLException, ClassNotFoundException {
        // Consulta SQL para insertar datos en la tabla
        String sql = "INSERT INTO clase_personalizada (id, tipo_clase, horario, entrenador_id, capacidad_maxima) VALUES (?, ?, ?, ?, ?)";

        // Establecer la conexión y preparar la consulta
        try (Connection conn = DataBase.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Obtener el id del entrenador asignado
            Entrenador entrenador = clase.getEntrenadorAsignado();
            int entrenadorId = entrenador.getId();  // Asegúrate de que Entrenador tenga un método getId()

            // Asignar los valores del objeto 'ClasePersonalizada' a los parámetros de la consulta SQL
            stmt.setInt(1, clase.getId());              
            stmt.setString(2, clase.getTipoClase());     
            stmt.setString(3, clase.getHorario());      
            stmt.setInt(4, entrenadorId);                
            stmt.setInt(5, clase.getCapacidadMaxima()); 

            // Ejecutar la inserción
            int rowsAffected = stmt.executeUpdate();

            // Retornar 'true' si se afectaron filas (significa que la inserción fue exitosa)
            return rowsAffected > 0;

        }catch (SQLException e) {
            // Imprimir el error si ocurre alguna excepción
            e.printStackTrace();
            return false;
        }
       
        
    }
    
}
