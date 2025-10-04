/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Repositorio;

import com.example.demo.Modelo.Usuario;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Laura
 */
@Repository
public class UsuarioRepository {
    private final List<Usuario> baseDeDatos=new ArrayList<>();
    private final List<String> authTokens=new ArrayList<>();
    
    public Usuario guardar(Usuario usuario){
        baseDeDatos.add(usuario);
        authTokens.add(usuario.getContrasena());
        return usuario;
    }
    public Usuario findByEmail(String email){
        for(Usuario usuario:baseDeDatos){
            if(usuario.getcorreoElectronico().equals(email)){
            return usuario;
        }
        }
            return null;
    }
    public List<Usuario> findAll(){
        return new ArrayList<>(baseDeDatos);
    }
    public void deleteByEmail(String email){
        for(int i=0;i<baseDeDatos.size();i++){
            if(baseDeDatos.get(i).getcorreoElectronico().equals(email)){
                baseDeDatos.remove(i);
                return;
            }
        }
        
    }
    public Usuario update(Usuario usuario){
           for(int i=0;i<baseDeDatos.size();i++){
            if(baseDeDatos.get(i).getcorreoElectronico().equals(usuario.getcorreoElectronico())){     
                baseDeDatos.set(i,usuario);
                return usuario;
            }
           }
           return null;
    }
    public List<Usuario> buscarPorFiltros(String nombre, String email) {
        List<Usuario> resultado = new ArrayList<>();
        for (Usuario usuario : baseDeDatos) {
            boolean coincideNombre = (nombre == null || usuario.getnombre().contains(nombre));
            boolean coincideEmail = (email == null || usuario.getcorreoElectronico().contains(email));
            if (coincideNombre && coincideEmail) {
                resultado.add(usuario);
            }
        }
        return resultado;
    }
}
