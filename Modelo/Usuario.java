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
    private String contaseña;
    private String rol;

    public int getId() {
        return id;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getContaseña() {
        return contaseña;
    }

    public String getRol() {
        return rol;
    }

    public void setContaseña(String contaseña) {
        this.contaseña = contaseña;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
    
}
