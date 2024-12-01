/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.ClasePersonalizada;

import Modelo.Dao.DAO;
import Modelo.Entrenador.Entrenador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author andre
 */
public class ClasePersonalizadaDAO extends DAO<ClasePersonalizadaDTO> {
    
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
    
    public boolean validatePK(Object id) throws SQLException {
        return read(id) == null;
    }

}
