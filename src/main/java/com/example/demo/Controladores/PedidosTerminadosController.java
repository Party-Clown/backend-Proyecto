/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controladores;

import com.example.demo.Modelo.PedidoTerminado;
import com.example.demo.Modelo.Usuario;
import com.example.demo.Service.PedidoTerminadoService;
import com.example.demo.Service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Laura
 */
@RestController
@RequestMapping("/api/pedidosT")
public class PedidosTerminadosController {
    private final PedidoTerminadoService usuarioService;
   
    
    @Autowired
    public PedidosTerminadosController(PedidoTerminadoService usuarioService){
        this.usuarioService=usuarioService;
    }
    
     @GetMapping
   public ResponseEntity<List<PedidoTerminado>> getAllPedidoTerminados(){
       List<PedidoTerminado> pedidot=usuarioService.findAll();
       return new ResponseEntity<>(pedidot, HttpStatus.OK);
   }
   
   @GetMapping("/{id}")
    public ResponseEntity<PedidoTerminado> getPedidoById(@PathVariable int id) {
        PedidoTerminado pedidot = usuarioService.findById(id);
        if (pedidot != null) {
            return new ResponseEntity<>(pedidot, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedidoTerminado(@PathVariable int id) {
        PedidoTerminado existingPedidoT = usuarioService.findById(id);
        if (existingPedidoT != null) {
            usuarioService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
