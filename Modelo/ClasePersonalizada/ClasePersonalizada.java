/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.ClasePersonalizada;


import DataBase.DataBase;
import Modelo.Entrenador.Entrenador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Student
 */
public class ClasePersonalizada {
    private int id;
    private String tipoClase;
    private String horario;
    private Entrenador entrenadorAsignado;
    private int capacidadMaxima;

    public int getId() {
        return id;
    }

    public String getTipoClase() {
        return tipoClase;
    }

    public String getHorario() {
        return horario;
    }

    public Entrenador getEntrenadorAsignado() {
        return entrenadorAsignado;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setEntrenadorAsignado(Entrenador entrenadorAsignado) {
        this.entrenadorAsignado = entrenadorAsignado;
    }

    public ClasePersonalizada(int id, String tipoClase, String horario, Entrenador entrenadorAsignado, int capacidadMaxima) {
        this.id = id;
        this.tipoClase = tipoClase;
        this.horario = horario;
        this.entrenadorAsignado = entrenadorAsignado;
        this.capacidadMaxima = capacidadMaxima;
    }

    public ClasePersonalizada() {
        this(0,"","",new Entrenador(),0);
    }  
    public void registrarAsistencia() {
        System.out.println("Asistencia registrada para la clase: " + tipoClase + ", horario: " + horario);
    }

    public boolean verificarDisponibilidad() {
        if (capacidadMaxima > 0) {
            System.out.println("Disponibilidad confirmada para la clase: " + tipoClase);
            return true;
        } else {
            System.out.println("No hay cupos disponibles para la clase: " + tipoClase);
            return false;
        }
    } 
    public void guardar() throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO clase_personalizada (tipo_clase, horario, id_entrenador, capacidad_maxima) VALUES (?, ?, ?, ?)";
        try (Connection connection = DataBase.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            
            statement.setString(1, this.tipoClase);
            statement.setString(2, this.horario);
            statement.setInt(3, this.entrenadorAsignado.getId()); // Asumiendo que tienes el ID del entrenador
            statement.setInt(4, this.capacidadMaxima);
            
            statement.executeUpdate();
        }
    }
    

}
