/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controladores;

import com.example.demo.Modelo.Usuario;
import com.example.demo.dto.LoginRequestDTO;
import com.example.demo.Service.UsuarioService;
import com.example.demo.dto.LoginResponseDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Laura
 */
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;
  
    
    @Autowired
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService=usuarioService;
       
    }
    
   @GetMapping
   public ResponseEntity<List<Usuario>> getAllUsuarios(){
       List<Usuario> usuarios=usuarioService.findAll();
       return new ResponseEntity<>(usuarios, HttpStatus.OK);
   }
   @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable int id) {
      return usuarioService.findById(id)
              .map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK))
              .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        Usuario newUsuario = usuarioService.guardar(usuario);
        return new ResponseEntity<>(newUsuario, HttpStatus.CREATED);
       }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable int id, @RequestBody Usuario usuario) {
         return usuarioService.findById(id)
                .map(existingUsuario -> {
                    usuario.setId(id);
                    Usuario updatedUsuario = usuarioService.guardar(usuario); // save() también actualiza
                    return new ResponseEntity<>(updatedUsuario, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable int id) {
       return usuarioService.findById(id)
                .map(existingUsuario -> {
                    usuarioService.deleteById(id);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
   @PostMapping(value = "/login", produces = "application/json")
   public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequest){
       try{
           LoginResponseDTO response =usuarioService.login(loginRequest);
           return ResponseEntity.ok(response);
       }catch(AuthenticationException e){
           return
                   ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Error: credenciales invalidas");
       }
   }
  
}


