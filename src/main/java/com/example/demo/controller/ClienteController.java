/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Cliente;
import com.example.demo.model.Producto;
import com.example.demo.repository.ClienteRepository;
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



@RestController
@RequestMapping("/api")
@CrossOrigin

/**
 *
 * @author Leo González
 */
public class ClienteController {
    @Autowired
    ClienteRepository clienterepository;
    
    @GetMapping("/cliente")
    public List<Cliente> getAllClientes(){
        return clienterepository.findAll();
        
    }
     @PostMapping("/cliente")
    public Cliente createCliente(@Valid @RequestBody Cliente cliente) {
        return clienterepository.saveAndFlush(cliente);
    }

    @GetMapping("/cliente/{id}")
    public Cliente getProductoById(@PathVariable(value = "id") Long clienteId) {
        return clienterepository.findById(clienteId)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente", "id", clienteId));
    }

    @PutMapping("/cliente/{id}")
    public Cliente updateCliente(@PathVariable(value = "id") Long clienteId,
                                           @Valid @RequestBody Cliente clienteDetails) {
        Cliente cliente = clienterepository.findById(clienteId)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente", "id", clienteId));
        cliente.nombre = clienteDetails.nombre;
        cliente.apellidos = clienteDetails.apellidos;
        cliente.sexo = clienteDetails.sexo;
        cliente.edad = clienteDetails.edad;
        cliente.email = clienteDetails.email;
        cliente.telefono = clienteDetails.telefono;

        Cliente updatedCliente = clienterepository.saveAndFlush(cliente);
        return updatedCliente;
    }

    @DeleteMapping("/cliente/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable(value = "id") Long clienteId) {
        Cliente cliente = clienterepository.findById(clienteId)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente", "id", clienteId));
        clienterepository.delete(cliente);
        return ResponseEntity.ok().build();
    }
            
    
    
}
