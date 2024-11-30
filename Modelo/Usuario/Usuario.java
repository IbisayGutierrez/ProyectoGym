/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Usuario;

import Modelo.Rol;

/**
 *
 * @author andre
 */
public class Usuario {
    private int id;
    private String Nombre;
    private String Password;
    private Rol rol;

    public int getId() {
        return id;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getPassword() {
        return Password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Usuario(int id, String Nombre, String Password, Rol rol) {
        this.id = id;
        this.Nombre = Nombre;
        this.Password = Password;
        this.rol = rol;
    }

    public Usuario() {
        this(0,"","",Rol.ADMINISTRADOR);
    }

    public boolean validarCredenciales(String nombre, String contraseña) {
        return this.Nombre.equals(nombre) && this.Password.equals(Password);
    }
    
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", Nombre=" + Nombre + ", contase\u00f1a=" + Password + ", rol=" + rol + '}';
    }
    
    
}
