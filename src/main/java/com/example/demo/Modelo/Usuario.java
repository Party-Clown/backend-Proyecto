/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

/**
 *
 * @author Laura
 */
@Entity 
@Table(name = "usuarios")
public class Usuario {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   @Column(nullable = false, unique = true) 
   private String correoElectronico; 
   @Column(nullable = false)
   private String nombre;
   @Transient
   private String rol;
    @Column(nullable = false)
   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
   private String contrasena;
   @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
   private List<ItemsPedidos> pedidos; 
   
   
       
     public Usuario(){
        
    }

    public Usuario(String correoElectronico, String contrasena, String nombre, int id) {
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.id = id;
        
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreoElectronico() { return correoElectronico; }
    public void setCorreoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public List<ItemsPedidos> getUsuarios() {
    	return pedidos;
    	}
    public void setusuarios(List<ItemsPedidos> pedidos) {
    	this.pedidos = pedidos; 
    	}

}
    

