/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Repositorio;

import com.example.demo.Modelo.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Laura
 */
@Repository
public class UsuarioRepository {
    private final List<Usuario> baseDeDatos=new ArrayList<>();
    private static int contador=1;
    private final List<String> authTokens=new ArrayList<>();
    
    
    public Usuario guardar(Usuario usuario){
        usuario.setId(contador++);
        baseDeDatos.add(usuario);
        return usuario;
    }
    public Usuario findById(int id){
        for(Usuario usuario:baseDeDatos){
            if(usuario.getId()==(id)){
            return usuario;
        }
        }
            return null;
    }
    public List<Usuario> findAll(){
        return new ArrayList<>(baseDeDatos);
    }
    public void  deleteById(int id){
        for(int i=0;i<baseDeDatos.size();i++){
            if(baseDeDatos.get(i).getId()==id){
                baseDeDatos.remove(i);
                return;
            }
        }
        
    }
    public Usuario update(Usuario usuario){
           for(int i=0;i<baseDeDatos.size();i++){
            if(baseDeDatos.get(i).getCorreoElectronico().equals(usuario.getCorreoElectronico())){     
                baseDeDatos.set(i,usuario);
                return usuario;
            }
           }
           return null;
    }
    public List<Usuario> buscarPorFiltros(String nombre,Integer id) {
        List<Usuario> resultado = new ArrayList<>();
        for (Usuario usuario : baseDeDatos) {
            boolean coincideNombre = (nombre == null || usuario.getNombre().contains(nombre));
            boolean coincideId = (id == null || usuario.getId()==(id));
            if (coincideNombre && coincideId) {
                resultado.add(usuario);
            }
        }
        return resultado;
    }
    public Optional<Usuario> findByEmail(String email) {
        return baseDeDatos.stream()
        .filter(u -> u.getCorreoElectronico() != null && u.getCorreoElectronico().equalsIgnoreCase(email))
        .findFirst();
    }
    public Optional<Usuario> validarCredenciales(String email, String contrasena) {
        Optional<Usuario> u = findByEmail(email);
        if (u.isPresent() && u.get().getContrasena() != null && u.get().getContrasena().equals(contrasena)) {
        return u;
    }
        return Optional.empty();
    }
    
}

