/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Admin;
import com.example.demo.model.Proveedores;
import com.example.demo.repository.AdminRepository;
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
public class AdminController {
     @Autowired
    AdminRepository adminRepository;
     
     @GetMapping("/admin")
    public List<Admin> getAllAdmin(){
        return adminRepository.findAll();
        
    }
     @PostMapping("/admin")
    public Admin createAdmin(@Valid @RequestBody Admin adm) {
        return adminRepository.saveAndFlush(adm);
    }

    @GetMapping("/admin/{id}")
    public Admin getAdminById(@PathVariable(value = "id") Long adminId) {
        return adminRepository.findById(adminId)
                .orElseThrow(() -> new ResourceNotFoundException("Admin", "id", adminId));
    }

    @PutMapping("/admin/{id}")
    public Admin updateAdmin(@PathVariable(value = "id") Long adminId,
                                           @Valid @RequestBody Admin adminDetails) {
        Admin adm = adminRepository.findById(adminId)
                .orElseThrow(() -> new ResourceNotFoundException("Admin", "id", adminId));
        adm.nombre = adminDetails.nombre;
        adm.apellidos = adminDetails.apellidos;
        adm.direccion = adminDetails.direccion;
        adm.correo = adminDetails.correo;
        adm.telefono = adminDetails.telefono;
        
        Admin updateAdmin = adminRepository.saveAndFlush(adm);
        return updateAdmin;
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<?> deleteAdmin(@PathVariable(value = "id") Long adminId) {
        Admin adm = adminRepository.findById(adminId)
                .orElseThrow(() -> new ResourceNotFoundException("Admin", "id", adminId));
        adminRepository.delete(adm);
        return ResponseEntity.ok().build();
    }
    
}
