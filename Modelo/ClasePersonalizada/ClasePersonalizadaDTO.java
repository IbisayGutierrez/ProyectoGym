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
public class ClasePersonalizadaDTO {
     private final int id;
    private  final String tipoClase;
    private  final String horario;
    private final Entrenador entrenadorAsignado;
    private final int capacidadMaxima;

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

    public ClasePersonalizadaDTO(int id, String tipoClase, String horario, Entrenador entrenadorAsignado, int capacidadMaxima) {
        this.id = id;
        this.tipoClase = tipoClase;
        this.horario = horario;
        this.entrenadorAsignado = entrenadorAsignado;
        this.capacidadMaxima = capacidadMaxima;
    }     
}
