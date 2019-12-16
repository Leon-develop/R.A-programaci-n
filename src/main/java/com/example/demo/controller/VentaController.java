/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Empleado;
import com.example.demo.model.Ventas;
import com.example.demo.repository.VentaRepository;
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
public class VentaController {
    @Autowired
   VentaRepository ventaRepository;
    
     @GetMapping("/venta")
    public List<Ventas> getAllVentas(){
        return ventaRepository.findAll();
        
    }
     @PostMapping("/venta")
    public Ventas createVentas(@Valid @RequestBody Ventas vent) {
        return ventaRepository.saveAndFlush(vent);
    }

    @GetMapping("/venta/{id}")
    public Ventas getVentasById(@PathVariable(value = "id") Long ventaId) {
        return ventaRepository.findById(ventaId)
                .orElseThrow(() -> new ResourceNotFoundException("Ventas", "id", ventaId));
    }

    @PutMapping("/venta/{id}")
    public Ventas updateVentas(@PathVariable(value = "id") Long ventaId,
                                           @Valid @RequestBody Ventas ventaDetails) {
        Ventas vent = ventaRepository.findById(ventaId)
                .orElseThrow(() -> new ResourceNotFoundException("Ventas", "id", ventaId));
        vent.detalleventa = ventaDetails.detalleventa;
        vent.fecha = ventaDetails.fecha;               
        Ventas updateVentas = ventaRepository.saveAndFlush(vent);
        return updateVentas;
    }

    @DeleteMapping("/venta/{id}")
    public ResponseEntity<?> deleteVentas(@PathVariable(value = "id") Long ventaId) {
        Ventas vent = ventaRepository.findById(ventaId)
                .orElseThrow(() -> new ResourceNotFoundException("Ventas", "id", ventaId));
        ventaRepository.delete(vent);
        return ResponseEntity.ok().build();
    }
    
}
