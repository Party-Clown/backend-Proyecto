/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author Laura
 */
@Entity
@Table(name="Pedidos")
public class ItemsPedidos implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable=false)
    private String categoria;
    @Column(nullable=false)
    private String nombre;
    @Column(nullable = false)
    private Integer cantidad;
    @Column(nullable = false)
    private double precioUnitario;
    @Column(nullable = false)
    private String Estado="EN PROCESO";
    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;
            
    public ItemsPedidos(){
        
    }

    public ItemsPedidos(String nombre, int cantidad, double precioUnitario) {
      
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.Estado=Estado;
    }
   

    public ItemsPedidos(String categoria, String nombre, int cantidad, double precioUnitario,String Usuario) {
        this.categoria = categoria;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.usuario=usuario;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
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
