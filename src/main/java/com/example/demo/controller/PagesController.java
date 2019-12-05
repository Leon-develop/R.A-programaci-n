package com.example.demo.controller;

import com.example.demo.model.Producto;
import com.example.demo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class PagesController {
	@Autowired
	ProductoRepository productoRepository;

	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("message", "Hola Mundo !!");
		for (Producto p: productoRepository.findAll() ) {
			System.out.println(p.nombre);
		}
		model.addAttribute("productos", productoRepository.findAll());
		return "index";
	}
	
	@RequestMapping("/next")
	public String next(Map<String, Object> model) {
		model.put("message", "Vas muy bien !!!");
		return "next";
	}

}