/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Pago;

import Modelo.Cliente.Cliente;
import Modelo.Dao.DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author andre
 */
public class PagoDAO extends DAO<PagoDTO> {

    public PagoDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(PagoDTO dto) throws SQLException {
        if (dto == null || !validatePK(dto.getIdPago())) {
            return false;
        }
        String query = "Call PagoCreate(?,?,?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, dto.getIdPago());
            stmt.setString(2, dto.getCliente().getContacto());
            stmt.setDate(3, (Date) dto.getFecha());
            stmt.setDouble(4, dto.getSubtotal());
            stmt.setDouble(5, dto.getImpuesto());
            stmt.setDouble(6, dto.getTotal());
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public PagoDTO read(Object id) throws SQLException {
         if (id == null || String.valueOf(id).trim().isEmpty()) {
        return null;
    }
    String query = "Call PagoRead(?)";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setInt(1, (Integer) id); 
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                Cliente cliente = new Cliente(); 
                cliente.setContacto(rs.getString(2)); 
                return new PagoDTO(
                        rs.getInt(1),
                        cliente, 
                        rs.getDate(3), 
                        rs.getDouble(4), 
                        rs.getDouble(5), 
                        rs.getDouble(6)  
                );
            }
        }
    }
    return null;
    }

    @Override
    public boolean update(PagoDTO dto) throws SQLException {
          if (dto == null) {
            return false;
        }
        String query = "Call PagoUpdate(?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, dto.getCliente().getContacto());
            stmt.setDate(2, (Date) dto.getFecha());
            stmt.setDouble(3, dto.getTotal());
            stmt.setInt(4, dto.getIdPago());
            return stmt.executeUpdate() > 0;

        }
    }

    @Override
    public boolean delete(Object id) throws SQLException {
          if (id == null || String.valueOf(id).trim().isEmpty()) {
            return false;
        }
        String query = "Call PagoDelete(?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, String.valueOf(id));
            return stmt.executeUpdate() > 0;

        }
    }
    
    public boolean validatePK(Object id) throws SQLException {
        return read(id) == null;
    }
}
