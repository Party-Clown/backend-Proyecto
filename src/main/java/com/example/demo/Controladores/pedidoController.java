/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controladores;

import com.example.demo.Modelo.Pedido;
import com.example.demo.Modelo.Usuario;
import com.example.demo.Repositorio.PedidoRepository;

import com.example.demo.Service.PedidoService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Laura
 */
@RestController
@RequestMapping("/api/pedidos")
public class pedidoController {
    private final PedidoService pedidoS;
    
    @Autowired
    public pedidoController(PedidoService pedidoS){
        this.pedidoS=pedidoS;
    }
    
    @GetMapping
   public ResponseEntity<List<Pedido>> getAllPedidos(){
       List<Pedido> usuarios=pedidoS.findAll();
       return new ResponseEntity<>(usuarios, HttpStatus.OK);
   }
   @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable int id) {
        Pedido pedido = pedidoS.findById(id);
        if (pedido != null) {
            return new ResponseEntity<>(pedido, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
   @PostMapping
    public ResponseEntity<Pedido> crearPedido(@RequestBody Pedido pedido){
        if(pedido==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
       if(pedido.getCorreoUsuario()==null || pedido.getCorreoUsuario().isEmpty()){
           pedido.setCorreoUsuario("anonimo"); 
       }
      if(pedido.getNombreUsuario()==null || pedido.getNombreUsuario().isEmpty()){
          pedido.setNombreUsuario(pedido.getCorreoUsuario());
      }
      Pedido creado=pedidoS.save(pedido);
      return new ResponseEntity<>(creado,HttpStatus.OK);
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable int id) {
        Pedido existingPedido = pedidoS.findById(id);
        if (existingPedido != null) {
            pedidoS.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}/estado/{nuevoEstado}")
    public ResponseEntity<Void> actualizarEstadoPedido(
        @PathVariable int id,
        @PathVariable String nuevoEstado) {
    boolean exito = pedidoS.actualizarEstadoPedido(id, nuevoEstado);
    if (exito) {
        return ResponseEntity.ok().build();
    } else {
        return ResponseEntity.notFound().build();
    }
        
    }
    @PutMapping("/{id}/terminar")
    public ResponseEntity<Void> terminarPedido(@PathVariable int id){
        boolean terminado=pedidoS.terminarPedido(id);
        if(terminado){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
