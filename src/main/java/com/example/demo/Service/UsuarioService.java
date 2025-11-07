/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Service;

import com.example.demo.Modelo.Usuario;
import com.example.demo.Repositorio.UsuarioRepository;
import com.example.demo.Repositorio.UsuariosRepository;

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
	@Autowired
        private UsuariosRepository usuarioRepository;
    
    private final String ADMIN_EMAIL = "admin@gmail.com";
    private final String ADMIN_PASSWORD = "Admin123";

   
     public Usuario guardar(Usuario usuario){
         return usuarioRepository.save(usuario);
     }
     public Optional<Usuario> findById(int id){
         return usuarioRepository.findById(id);
     }
     public List<Usuario> findAll(){
         return usuarioRepository.findAll();
     }
     public void deleteById(int id){
         usuarioRepository.deleteById(id);
     }
    
      public List<Usuario> buscarPorFiltros(String nombre,Integer id) {
    	  if (nombre != null && !nombre.isEmpty()) {
              return usuarioRepository.findByNombreContainingIgnoreCase(nombre);
          } else if (id != null) {
              return usuarioRepository.findById(id)
                      .map(List::of)
                      .orElse(List.of());
          } else {
              return usuarioRepository.findAll();
          }
      }
      
     public Optional<Usuario> login(String correoElectronico, String contrasena) {

    	 if (ADMIN_EMAIL.equalsIgnoreCase(correoElectronico) && ADMIN_PASSWORD.equals(contrasena)) {
             Usuario admin = new Usuario();
             admin.setCorreoElectronico(correoElectronico);
             admin.setContrasena(ADMIN_PASSWORD);
             admin.setNombre("Administrador");
             admin.setRol("ADMIN");
             return Optional.of(admin);
         }

         // Si no, buscar en la base de datos
         return usuarioRepository.findBycorreoElectronicoAndContrasena(correoElectronico, contrasena);
     }
     


   
    public Optional<Usuario> findBycorreoElectronico(String correoElectronico) {
    	return usuarioRepository.findBycorreoElectronico(correoElectronico);
}
    
   
}
