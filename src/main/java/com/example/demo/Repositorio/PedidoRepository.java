/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Repositorio;

import com.example.demo.Modelo.Pedido;
import com.example.demo.Modelo.Usuario;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Laura
 */
@Repository
public class PedidoRepository {
   private final List<Pedido> baseDeDatos=new ArrayList<>();
   
   public Pedido save(Pedido pedido){
        baseDeDatos.add(pedido);
        return pedido;
    }
   public List<Pedido> findAll(){
       return new ArrayList<>(baseDeDatos);
   }
   public Pedido findById(int id){
       for(Pedido pedido:baseDeDatos){
            if(pedido.getId()==(id)){
            return pedido;
        }
        }
            return null;
    }
   public void deleteById(int id){
        for(int i=0;i<baseDeDatos.size();i++){
            if(baseDeDatos.get(i).getId()==id){
                baseDeDatos.remove(i);
                return;
            }
        }
        
    }
}
