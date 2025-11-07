/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Repositorio;

import com.example.demo.Modelo.PedidoTerminado;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Laura
 */
@Repository
public class PedidoTerminadoRepository {
     private final List<PedidoTerminado> baseDeDatos=new ArrayList<>();
    
    
    
    public PedidoTerminado guardar(PedidoTerminado pedidot){
      baseDeDatos.add(pedidot);
        return pedidot;
    }
    public PedidoTerminado findById(int id){
        for(PedidoTerminado pedidot:baseDeDatos){
            if(pedidot.getId()==(id)){
            return pedidot;
        }
        }
            return null;
    }
    public List<PedidoTerminado> findAll(){
        return new ArrayList<>(baseDeDatos);
    }
    public void  deleteById(int id){
        for(int i=0;i<baseDeDatos.size();i++){
            if(baseDeDatos.get(i).getId()==id){
                baseDeDatos.remove(i);
                return;
            }
        }
        
    }
  
    
    
}
