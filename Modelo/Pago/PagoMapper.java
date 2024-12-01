/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Pago;

import Modelo.Mapper.Mapper;
import java.sql.SQLException;

/**
 *
 * @author Dell
 */
public class PagoMapper implements Mapper<Pago,PagoDTO> {

    @Override
    public PagoDTO toDTO(Pago ent) {
     if (ent == null) {
            return null; // Manejo de objetos nulos
        }
        return new PagoDTO(
                ent.getIdPago(),          // Mapear ID del pago
                ent.getCliente(),         // Mapear cliente (directamente si es el mismo objeto en DTO)
                ent.getFecha(),           // Mapear fecha
                ent.getSubtotal(),        // Mapear subtotal
                ent.getImpuesto(),        // Mapear impuesto
                ent.getTotal()            // Mapear total
        );
    }

    @Override
    public Pago toEnt(PagoDTO dto) throws SQLException {
     if (dto == null) {
            return null; // Manejo de objetos nulos
        }
        return new Pago(
                dto.getIdPago(),          // Mapear ID del pago
                dto.getCliente(),         // Mapear cliente (directamente si es el mismo objeto en la entidad)
                dto.getFecha(),           // Mapear fecha
                dto.getSubtotal(),        // Mapear subtotal
                dto.getImpuesto(),        // Mapear impuesto
                dto.getTotal()            // Mapear total
        );
    }
    
}
