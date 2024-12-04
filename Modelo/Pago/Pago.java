/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Pago;

import Modelo.Cliente.Cliente;
import java.util.Date;

/**
 *
 * @author Student
 */public class Pago {
   private int idPago;
    private Cliente cliente;
    private Date fecha;
    private double subtotal;
    private double impuesto;
    private double total;

    public int getIdPago() {
        return idPago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public double getTotal() {
        return total;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    

    public Pago(int idPago, Cliente cliente, Date fecha, double subtotal, double impuesto, double total) {
        this.idPago = idPago;
        this.cliente = cliente;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.impuesto = impuesto;
        this.total = total;
    }

    public Pago() {
        this(0,new Cliente(),new Date(),0,0,0);
    }
    
    public double CalcularTotal(){
    return subtotal + impuesto;
}


  
}
