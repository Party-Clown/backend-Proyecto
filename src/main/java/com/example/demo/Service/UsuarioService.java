/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Service;

import com.example.demo.Modelo.Usuario;
import com.example.demo.Repositorio.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Laura
 */
@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    
    private final String ADMIN_EMAIL = "admin@gmail.com";
    private final String ADMIN_PASSWORD = "Admin123";

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository=usuarioRepository;
    }
     public Usuario guardar(Usuario usuario){
         return usuarioRepository.guardar(usuario);
     }
     public Usuario findById(int id){
         return usuarioRepository.findById(id);
     }
     public List<Usuario> findAll(){
         return usuarioRepository.findAll();
     }
     public void deleteByEmail(int id){
         usuarioRepository.deleteById(id);
     }
     public Usuario update(Usuario usuario){
         return usuarioRepository.update(usuario);
     }
      public List<Usuario> buscarPorFiltros(String nombre,Integer id) {
          return usuarioRepository.buscarPorFiltros(nombre,id);
      }
     public Optional<Usuario> login(String email, String contrasena) {
// primero comprobar admin fijo
    if (ADMIN_EMAIL.equalsIgnoreCase(email) && ADMIN_PASSWORD.equals(contrasena)) {
    Usuario admin = new Usuario(ADMIN_EMAIL,ADMIN_PASSWORD,"Administrador",0,"ADMIN");
    return Optional.of(admin);
}
// sino comprobar en repositorio
return usuarioRepository.validarCredenciales(email, contrasena);
}
   
    public Optional<Usuario> findByEmail(String email) {
return usuarioRepository.findByEmail(email);
}
    
   
}
