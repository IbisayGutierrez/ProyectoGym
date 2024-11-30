/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.ClasePersonalizada;

import Modelo.Dao.DAO;
import java.sql.Connection;
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
    public boolean create(ClasePersonalizadaDAO dto) throws SQLException {
        
    }

    @Override
    public ClasePersonalizadaDAO read(Object id) throws SQLException {
    }

    @Override
    public boolean update(ClasePersonalizadaDAO dto) throws SQLException {
    }

    @Override
    public boolean delete(Object id) throws SQLException {
    }
    
    public boolean validatePK(Object id) throws SQLException {
        return read(id) == null;
    }
}
