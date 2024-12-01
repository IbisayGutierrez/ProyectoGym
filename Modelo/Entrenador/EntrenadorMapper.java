/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Entrenador;

import Modelo.Mapper.Mapper;
import java.sql.SQLException;

/**
 *
 * @author Dell
 */
public class EntrenadorMapper implements Mapper<Entrenador,EntrenadorDTO> {

    @Override
    public EntrenadorDTO toDTO(Entrenador ent) {
     
        if (ent == null) {
            return null; 
        }
        return new EntrenadorDTO(
                ent.getId(),               
                ent.getNombre(),           
                ent.getContacto(),         
                ent.getEspecialidades()    
                
        );
    }

    @Override
    public Entrenador toEnt(EntrenadorDTO dto) throws SQLException {
    if (dto == null) {
            return null; 
        }
        return new Entrenador(
                dto.getId(),               
                dto.getNombre(),           
                dto.getContacto(),         
                dto.getEspecialidades()    
        );
    }
    
}
