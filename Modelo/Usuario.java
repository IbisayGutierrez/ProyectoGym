/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author andre
 */
public class Usuario {
    private int id;
    private String Nombre;
    private String contraseña;
    private String rol;

    public int getId() {
        return id;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getContaseña() {
        return contraseña;
    }

    public String getRol() {
        return rol;
    }

    public void setContaseña(String contaseña) {
        this.contraseña = contaseña;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Usuario(int id, String Nombre, String contaseña, String rol) {
        this.id = id;
        this.Nombre = Nombre;
        this.contraseña = contaseña;
        this.rol = rol;
    }

    public Usuario() {
        this(0,"","","");
    }

    public boolean validarCredenciales(String nombre, String contraseña) {
        return this.Nombre.equals(nombre) && this.contraseña.equals(contraseña);
    }
    
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", Nombre=" + Nombre + ", contase\u00f1a=" + contraseña + ", rol=" + rol + '}';
    }
    
    
}
