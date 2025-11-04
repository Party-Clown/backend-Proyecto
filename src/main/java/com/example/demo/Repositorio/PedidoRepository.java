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
import java.util.stream.BaseStream;

/**
 *
 * @author Laura
 */
@Repository
public class PedidoRepository {
   private final List<Pedido> baseDeDatos=new ArrayList<>();
 
     
     public Pedido save(Pedido pedido) {
        String correo = pedido.getCorreoUsuario();

        if(correo==null|| correo.isEmpty()){
            correo="anonimo";
        }
        int contador=0;
        for(Pedido p:baseDeDatos){
            if(p.getCorreoUsuario()!=null && p.getCorreoUsuario().equalsIgnoreCase(correo));
            contador++;
        }
      int nuevoNumero=contador +1;
      pedido.setId(nuevoNumero);
      pedido.setCorreoUsuario(correo);
      if(pedido.getNombreUsuario()==null || pedido.getNombreUsuario().isEmpty()){
          pedido.setNombreUsuario(correo);
      }
      baseDeDatos.add(pedido);
      System.out.print("pedido guardado");
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
   public boolean actualizarEstadoPedido(int id, String nuevoEstado) {
        Pedido pedido = findById(id);
        if (pedido != null) {
            pedido.setEstado(nuevoEstado);

            // Si el pedido tiene items, también se actualizan
            if (pedido.getItems() != null) {
                pedido.getItems().forEach(item -> item.setEstado(nuevoEstado));
            }

            System.out.println("✅ Pedido " + id + " actualizado a estado: " + nuevoEstado);
            return true;
        }
        return false;
    }

    // 🔹 Marcar un pedido como "Terminado"
    public boolean terminarPedido(int id) {
        Pedido pedido = findById(id);
        if (pedido != null) {
            pedido.setEstado("Terminado");

            if (pedido.getItems() != null) {
                pedido.getItems().forEach(item -> item.setEstado("Terminado"));
            }

            System.out.println("✅ Pedido " + id + " marcado como TERMINADO");
            return true;
        }
        return false;
    }
   
}
