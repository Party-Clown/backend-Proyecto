/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Service;

import com.example.demo.Modelo.PedidoTerminado;
import com.example.demo.Repositorio.PedidoRepository;
import com.example.demo.Repositorio.PedidoTerminadoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Laura
 */
@Service
public class PedidoTerminadoService {
    private PedidoTerminadoRepository pedidosT;
    private PedidoRepository pedido;
   @Autowired
    public PedidoTerminadoService(PedidoTerminadoRepository pedidosT,PedidoRepository pedido){
        this.pedidosT=pedidosT;
        this.pedido=pedido;
    }
    public PedidoTerminado guardar(PedidoTerminado pedidot){
        return pedidosT.guardar(pedidot);
    }
    public PedidoTerminado findById(int id){
        return pedidosT.findById(id);
    }
    public List<PedidoTerminado> findAll(){
        return pedidosT.findAll();
    }
     public void  deleteById(int id){
         pedidosT.deleteById(id);
     }
     
}
