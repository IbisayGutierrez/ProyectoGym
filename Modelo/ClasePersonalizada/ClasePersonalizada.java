/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.ClasePersonalizada;


import Modelo.Entrenador.Entrenador;

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

}
