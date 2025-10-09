/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Modelo;

import java.io.Serializable;

/**
 *
 * @author Laura
 */
public class ItemsPedidos implements Serializable {
    private String categoria;
    private String nombre;
    private int cantidad;
    private double precioUnitario;
    private String usuario;
            
    public ItemsPedidos(){
        
    }

    public ItemsPedidos(String nombre, int cantidad, double precioUnitario) {
      
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }
   

    public ItemsPedidos(String categoria, String nombre, int cantidad, double precioUnitario,String Usuario) {
        this.categoria = categoria;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.usuario=usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
    public double getSubtotal(){
        return cantidad*precioUnitario;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
       @Override
    public String toString() {
        return nombre + " x" + cantidad + " - $" + getSubtotal();
    }    

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    
    
}
