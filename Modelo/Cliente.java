/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author andre
 */
public class Cliente {
    private int id;
    private String nombre;
    private Date fechaNacimiento; 
    private String contacto;        
    private String tipoMembresia;

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

    public void setTipoMembresia(String tipoMembresia) {
        this.tipoMembresia = tipoMembresia;
    }

    public Cliente(int id, String nombre, Date fechaNacimiento, String contacto, String tipoMembresia) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.contacto = contacto;
        this.tipoMembresia = tipoMembresia;
    }

    public Cliente() {
        this(0,"",new Date(),"","");
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", contacto=" + contacto + ", tipoMembresia=" + tipoMembresia + '}';
    }
     
}
