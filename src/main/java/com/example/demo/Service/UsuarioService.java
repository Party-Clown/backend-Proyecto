/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Service;

import com.example.demo.Modelo.Usuario;
import com.example.demo.Repositorio.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Laura
 */
@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository=usuarioRepository;
    }
     public Usuario guardar(Usuario usuario){
         return usuarioRepository.guardar(usuario);
     }
     public Usuario findByEmail(String email){
         return usuarioRepository.findByEmail(email);
     }
     public List<Usuario> findAll(){
         return usuarioRepository.findAll();
     }
     public void deleteByEmail(String email){
         usuarioRepository.deleteByEmail(email);
     }
     public Usuario update(Usuario usuario){
         return usuarioRepository.update(usuario);
     }
      public List<Usuario> buscarPorFiltros(String nombre, String email) {
          return usuarioRepository.buscarPorFiltros(nombre, email);
      }
}
