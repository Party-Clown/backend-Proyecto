/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controladores;

import com.example.demo.Modelo.Usuario;
import com.example.demo.Service.UsuarioService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/api/usuarios")
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
   @GetMapping("/{email}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable String email) {
        Usuario usuario = usuarioService.findByEmail(email);
        if (usuario != null) {
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        Usuario newUsuario = usuarioService.guardar(usuario);
        return new ResponseEntity<>(newUsuario, HttpStatus.CREATED);
    }

    @PutMapping("/{email}")
    public ResponseEntity<Usuario> update(@PathVariable String email, @RequestBody Usuario usuario) {
        Usuario existingUsuario = usuarioService.findByEmail(email);
        if (existingUsuario != null) {
            usuario.setcorreoElectronico(email);
            Usuario updatedUsuario = usuarioService.update(usuario);
            return new ResponseEntity<>(updatedUsuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable String email) {
        Usuario existingUsuario = usuarioService.findByEmail(email);
        if (existingUsuario != null) {
            usuarioService.deleteByEmail(email);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Usuario>> buscarUsuarios(@RequestParam String nombre,
            @RequestParam(required = false) String email, @RequestParam int edad) {
        List<Usuario> usuarios = usuarioService.buscarPorFiltros(nombre, email);
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    
}
