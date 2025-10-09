/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controladores;

import com.example.demo.Modelo.Usuario;
import com.example.demo.Service.UsuarioService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
@RequestMapping("/api/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;
   
    
    @Autowired
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService=usuarioService;
    }
    public static class LoginRequest {
        public String email;
        public String password;
    }
   @GetMapping
   public ResponseEntity<List<Usuario>> getAllUsuarios(){
       List<Usuario> usuarios=usuarioService.findAll();
       return new ResponseEntity<>(usuarios, HttpStatus.OK);
   }
   @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable int id) {
        Usuario usuario = usuarioService.findById(id);
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

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable int id, @RequestBody Usuario usuario) {
        Usuario existingUsuario = usuarioService.findById(id);
        if (existingUsuario != null) {
            usuario.setId(id);
            Usuario updatedUsuario = usuarioService.update(usuario);
            return new ResponseEntity<>(updatedUsuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable int id) {
        Usuario existingUsuario = usuarioService.findById(id);
        if (existingUsuario != null) {
            usuarioService.deleteByEmail(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Usuario>> buscarUsuarios(
     
     @RequestParam(required = false) String nombre,
     @RequestParam(required = false) Integer id
    ) {

        List<Usuario> usuarios = usuarioService.buscarPorFiltros(nombre,id);
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }
  @PostMapping("/login")
public ResponseEntity<?> login(@RequestBody LoginRequest req) {
if (req == null || req.email == null || req.password == null) {
return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Faltan credenciales");
}


Optional<Usuario> opt = usuarioService.login(req.email, req.password);
if (opt.isPresent()) {
Usuario u = opt.get();
Map<String, Object> resp = new HashMap<>();
resp.put("message", "OK");
resp.put("role", u.getRol());
resp.put("email", u.getCorreoElectronico());
resp.put("id", u.getId());
return ResponseEntity.ok(resp);
}
return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
}
}


