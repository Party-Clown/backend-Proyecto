/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Modelo;



/**
 *
 * @author Laura
 */
public class Usuario {
    private String correoElectronico;
    private String contrasena;
    private String nombre;

    public Usuario(String correoElectronico, String contrasena, String nombre) {
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
        this.nombre = nombre;
    }

    public String getcorreoElectronico() {
        return correoElectronico;
    }

    public void setcorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
