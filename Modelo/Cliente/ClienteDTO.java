/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Cliente;

import java.util.Date;

/**
 *
 * @author Student
 */
public class ClienteDTO {
    private final int id;
    private final String nombre;
    private final Date fechaNacimiento; 
    private final String contacto;        
    private final String tipoMembresia;

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getContacto() {
        return contacto;
    }

    public String getTipoMembresia() {
        return tipoMembresia;
    }

    public ClienteDTO(int id, String nombre, Date fechaNacimiento, String contacto, String tipoMembresia) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.contacto = contacto;
        this.tipoMembresia = tipoMembresia;
    }
    
    
    
}
