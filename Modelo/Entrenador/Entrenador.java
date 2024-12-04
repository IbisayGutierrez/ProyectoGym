/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Entrenador;

/**
 *
 * @author andre
 */
public class Entrenador {
    private int id;
    private String nombre;
    private String contacto;
    private String especialidades;

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public String getEspecialidades() {
        return especialidades;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecialidades(String especialidades) {
        this.especialidades = especialidades;
    }
    
    public Entrenador(int id, String nombre, String contacto, String especialidades) {
        this.id = id;
        this.nombre = nombre;
        this.contacto = contacto;
        this.especialidades = especialidades;
    }

    public Entrenador() {
        this(0,"","","");
    }

    public void asignarClase(String clase) {
        this.especialidades = clase;
        System.out.println("Clase asignada: " + clase);
    }

    @Override
    public String toString() {
        return "Entrenador{" + "id=" + id + ", nombre=" + nombre + ", contacto=" + contacto + ", especialidades=" + especialidades + '}';
    }
    
    
}
