/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Service;

import com.example.demo.Modelo.Pedido;
import com.example.demo.Repositorio.PedidoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Laura
 */
@Service
public class PedidoService {
    private final PedidoRepository pedidoR;
    
    @Autowired
    public PedidoService(PedidoRepository pedidoR){
        this.pedidoR=pedidoR;
    }
    public Pedido save(Pedido pedido){
        return pedidoR.save(pedido);
    }
     public List<Pedido> findAll(){
         return pedidoR.findAll();
     }
     public Pedido findById(int id){
         return pedidoR.findById(id);
     }
      public void deleteById(int id){
         pedidoR.deleteById(id);
     }
      
}
