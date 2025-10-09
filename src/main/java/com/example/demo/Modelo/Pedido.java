/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Laura
 */
public class Pedido  {
   
 private Integer id;
 private List<ItemsPedidos> items=new ArrayList<>();
 
 
 public Pedido(){
     
 }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ItemsPedidos> getItems() {
        return items;
    }

    

    public void setItems(List<ItemsPedidos> items) {
        this.items = items;
    }
    public double getTotal(){
        return items.stream().mapToDouble(ItemsPedidos::getSubtotal).sum();
    }
 @Override
    public String toString() {
        return "pedido #" + " x" + "-Total: $" + getTotal();
    }
 
}
