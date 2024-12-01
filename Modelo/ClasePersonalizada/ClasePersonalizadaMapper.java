/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.ClasePersonalizada;

import Modelo.Mapper.Mapper;
import java.sql.SQLException;

/**
 *
 * @author Dell
 */
public class ClasePersonalizadaMapper implements Mapper<ClasePersonalizada,ClasePersonalizadaDTO> {

    @Override
    public ClasePersonalizadaDTO toDTO(ClasePersonalizada ent) {
        if (ent == null) {
            return null; 
        }
        return new ClasePersonalizadaDTO(
                ent.getId(),               
                ent.getTipoClase(),        
                ent.getHorario(),          
                ent.getEntrenadorAsignado(), 
                ent.getCapacidadMaxima()   
        );
    }

    @Override
    public ClasePersonalizada toEnt(ClasePersonalizadaDTO dto) throws SQLException {
      if (dto == null) {
            return null; // Manejo de casos nulos
        }
        return new ClasePersonalizada(
                dto.getId(),               
                dto.getTipoClase(),        
                dto.getHorario(),          
                dto.getEntrenadorAsignado(), 
                dto.getCapacidadMaxima()  
        );
      
    }
    
}
