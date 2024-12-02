/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Entrenador;

import Modelo.Dao.DAO;
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
public class EntrenadorDAO extends DAO<EntrenadorDTO> {

    public EntrenadorDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(EntrenadorDTO dto) throws SQLException {
         if (dto == null || !validatePK(dto.getId())) {
            return false;
        }
        String query = "Call EntrenadorCreate(?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, dto.getId());
            stmt.setString(2, dto.getEspecialidades());
            stmt.setString(3, dto.getContacto());
            stmt.setString(4, dto.getEspecialidades());
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public EntrenadorDTO read(Object id) throws SQLException {
        if (id == null || String.valueOf(id).trim().isEmpty()) {
            return null;
        }
        String query = "Call EntrenadorRead(?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, String.valueOf(id));
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new EntrenadorDTO(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4)
                    );
                }
            }
        }
        return null;
    }

    @Override
    public boolean update(EntrenadorDTO dto) throws SQLException {
         if (dto == null) {
            return false;
        }
        String query = "Call EntrenadorUpdate(?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, dto.getId());
            stmt.setString(2, dto.getContacto());
            stmt.setString(3, dto.getEspecialidades());
            return stmt.executeUpdate() > 0;

        }
    }

    @Override
    public boolean delete(Object id) throws SQLException {
         if (id == null || String.valueOf(id).trim().isEmpty()) {
            return false;
        }
        String query = "Call EntrenadorDelete(?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, String.valueOf(id));
            return stmt.executeUpdate() > 0;

        }
    }
    public List<EntrenadorDTO> readAll() throws SQLException {
    PreparedStatement stmt = connection.prepareStatement("CALL EntrenadorReadAll()");
    ResultSet rs = stmt.executeQuery();
    List<EntrenadorDTO> dtos = new ArrayList<>();
    while (rs.next()) {
        dtos.add(new EntrenadorDTO(
            rs.getInt(1),
            rs.getString(2),
            rs.getString(3),
            rs.getString(4)
        ));
    }
    return dtos;
}
    
    public boolean validatePK(Object id) throws SQLException {
        return read(id) == null;
    }
    
}
