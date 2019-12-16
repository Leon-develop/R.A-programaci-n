/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Admin;
import com.example.demo.model.Empleado;
import com.example.demo.repository.EmpleadoRepository;
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
public class EmpController {
    @Autowired
    EmpleadoRepository empleadoRepository;
    
     @GetMapping("/empleado")
    public List<Empleado> getAllEmpleado(){
        return empleadoRepository.findAll();
        
    }
     @PostMapping("/empleado")
    public Empleado createEmpleado(@Valid @RequestBody Empleado emp) {
        return empleadoRepository.saveAndFlush(emp);
    }

    @GetMapping("/empleado/{id}")
    public Empleado getEmpleadoById(@PathVariable(value = "id") Long empleadoId) {
        return empleadoRepository.findById(empleadoId)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado", "id", empleadoId));
    }

    @PutMapping("/empleado/{id}")
    public Empleado updateEmpleado(@PathVariable(value = "id") Long empleadoId,
                                           @Valid @RequestBody Empleado empleadoDetails) {
        Empleado emp = empleadoRepository.findById(empleadoId)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado", "id", empleadoId));
        emp.nombre = empleadoDetails.nombre;
        emp.apellidos = empleadoDetails.apellidos;
        emp.cargo = empleadoDetails.cargo;
        emp.telefono = empleadoDetails.telefono;       
        
        Empleado updateEmpleado = empleadoRepository.saveAndFlush(emp);
        return updateEmpleado;
    }

    @DeleteMapping("/empleado/{id}")
    public ResponseEntity<?> deleteEmpleado(@PathVariable(value = "id") Long empleadoId) {
        Empleado emp = empleadoRepository.findById(empleadoId)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado", "id", empleadoId));
        empleadoRepository.delete(emp);
        return ResponseEntity.ok().build();
    }
    
}
