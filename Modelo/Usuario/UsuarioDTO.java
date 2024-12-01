/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Usuario;

import Modelo.Rol;

/**
 *
 * @author Student
 */
public class UsuarioDTO {
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

    public UsuarioDTO(int id, String Nombre, String Password, Rol rol) {
        this.id = id;
        this.Nombre = Nombre;
        this.Password = Password;
        this.rol = rol;
    }
    
    
}
