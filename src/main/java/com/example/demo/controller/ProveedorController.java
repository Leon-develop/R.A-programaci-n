/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Cliente;
import com.example.demo.model.Proveedores;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.ProveedoresRepository;
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

public class ProveedorController {
     @Autowired
    ProveedoresRepository proveedoresRepository;
    
    @GetMapping("/proveedor")
    public List<Proveedores> getAllProveedor(){
        return proveedoresRepository.findAll();
        
    }
     @PostMapping("/proveedor")
    public Proveedores createProveedor(@Valid @RequestBody Proveedores proveedor) {
        return proveedoresRepository.saveAndFlush(proveedor);
    }

    @GetMapping("/proveedor/{id}")
    public Proveedores getProveedorById(@PathVariable(value = "id") Long proveedorId) {
        return proveedoresRepository.findById(proveedorId)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedores", "id", proveedorId));
    }

    @PutMapping("/proveedor/{id}")
    public Proveedores updateProveedor(@PathVariable(value = "id") Long proveedorId,
                                           @Valid @RequestBody Proveedores proveedorDetails) {
        Proveedores proveedor = proveedoresRepository.findById(proveedorId)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedores", "id", proveedorId));
        proveedor.nombre = proveedorDetails.nombre;
        proveedor.apellidos = proveedorDetails.apellidos;
        proveedor.correo = proveedorDetails.correo;
        proveedor.telefono = proveedorDetails.telefono;
        
        Proveedores updatedProveedor = proveedoresRepository.saveAndFlush(proveedor);
        return updatedProveedor;
    }

    @DeleteMapping("/proveedor/{id}")
    public ResponseEntity<?> deleteProveedor(@PathVariable(value = "id") Long proveedorId) {
        Proveedores proveedor = proveedoresRepository.findById(proveedorId)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedores", "id", proveedorId));
        proveedoresRepository.delete(proveedor);
        return ResponseEntity.ok().build();
    }
            
    
    
}
