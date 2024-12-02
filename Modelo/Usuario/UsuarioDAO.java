/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Usuario;

import Modelo.Dao.DAO;
import Modelo.Rol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andre
 */
public class UsuarioDAO extends DAO<UsuarioDTO> {

    public UsuarioDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(UsuarioDTO dto) throws SQLException {
       if (dto == null || !validatePK(dto.getId())) {
            return false;
        }
        String query = "Call UsuarioCreate(?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, dto.getId());
            stmt.setString(2, dto.getNombre());
            stmt.setString(3, dto.getPassword());
            stmt.setString(4, dto.getRol().name());
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public UsuarioDTO read(Object id) throws SQLException {
          if (id == null || String.valueOf(id).trim().isEmpty()) {
            return null;
        }
        String query = "Call UsuarioRead(?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, (Integer) id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new UsuarioDTO(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            Rol.valueOf(rs.getString(4)) 
                    );
                }
            }
        }
        return null;
        
    }

    @Override
    public boolean update(UsuarioDTO dto) throws SQLException {
        if (dto == null) {
            return false;
        }
        String query = "CALL UsuarioUpdate(?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, dto.getId());
            stmt.setString(2, dto.getPassword());
            stmt.setString(3, dto.getRol().name());
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean delete(Object id) throws SQLException {
         if (id == null || String.valueOf(id).trim().isEmpty()) {
            return false;
        }
        String query = "Call UsuarioDelete(?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, (Integer) id);
            return stmt.executeUpdate() > 0;
        }
    }
    
    public List<UsuarioDTO> readAll() throws SQLException {
    PreparedStatement stmt = connection.prepareStatement("CALL UsuarioReadAll()"); 
    ResultSet rs = stmt.executeQuery();  
    List<UsuarioDTO> dtos = new ArrayList<>();  

   
    while (rs.next()) {
       
        dtos.add(new UsuarioDTO(
            rs.getInt(1),              
            rs.getString(2),            
            rs.getString(3),            
                Rol.valueOf(rs.getString(4)) 
        ));
    }

    return dtos;  // Retornar la lista de DTOs
}
    
    public boolean validatePK(Object id) throws SQLException {
        return read(id) == null;
    }
    
}
