/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Cliente;

import Modelo.Mapper.Mapper;
import java.sql.SQLException;

/**
 *
 * @author Dell
 */
public class ClienteMapper implements Mapper<Cliente, ClienteDTO> {

    @Override
    public ClienteDTO toDTO(Cliente ent) {
      if (ent == null) {
            return null; 
        }
        return new ClienteDTO(
                ent.getId(),               
                ent.getNombre(),           
                ent.getFechaNacimiento(),  
                ent.getContacto(),         
                ent.getTipoMembresia()     
        );
    }

    @Override
    public Cliente toEnt(ClienteDTO dto) throws SQLException {
      if (dto == null) {
            return null; 
        }
        return new Cliente(
                dto.getId(),               
                dto.getNombre(),           
                dto.getFechaNacimiento(),  
                dto.getContacto(),         
                dto.getTipoMembresia()     
        );
    }
    
}
