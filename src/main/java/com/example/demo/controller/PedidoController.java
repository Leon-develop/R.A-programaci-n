/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Pedidos;
import com.example.demo.model.Proveedores;
import com.example.demo.repository.PedidoRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Leo González
 */
@RestController
@RequestMapping("/api")
@CrossOrigin

public class PedidoController {
     @Autowired
     PedidoRepository pedidoRepository;
     
     @GetMapping("/pedido")
      public List<Pedidos> getAllPedido(){
        return pedidoRepository.findAll();
      }
      
      @PostMapping("/pedido")
      public Pedidos createProveedor (@Valid @RequestBody Pedidos pedido){
          return pedidoRepository.saveAndFlush(pedido);
      }
      @GetMapping("/pedido/{id}")
    public Pedidos getPedidoById(@PathVariable(value = "id") Long pedidoId) {
        return pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new ResourceNotFoundException("Pedidos", "id", pedidoId));
    }
    @PutMapping("/pedido/{id}")
    public Pedidos updatePedido(@PathVariable(value = "id") Long pedidoId,
                                           @Valid @RequestBody Pedidos pedidoDetails) {
        Pedidos pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new ResourceNotFoundException("Pedidos", "id", pedidoId));
        pedido.concepto = pedidoDetails.concepto;
        pedido.cantidad = pedidoDetails.cantidad;
        pedido.precio = pedidoDetails.precio;
       
        
        Pedidos updatePedido = pedidoRepository.saveAndFlush(pedido);
        return updatePedido;
    }

    @DeleteMapping("/pedido/{id}")
    public ResponseEntity<?> deletePedido(@PathVariable(value = "id") Long pedidoId) {
        Pedidos pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new ResourceNotFoundException("Pedidos", "id", pedidoId));
        pedidoRepository.delete(pedido);
        return ResponseEntity.ok().build();
    }
            
    
    
}
