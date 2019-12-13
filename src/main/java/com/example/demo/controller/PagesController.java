package com.example.demo.controller;

import com.example.demo.model.Cliente;
import com.example.demo.model.Producto;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class PagesController {
	@Autowired
	private Environment env;
	@Autowired
	ProductoRepository productoRepository;
        @Autowired
        private Environment envc;
        @Autowired
        ClienteRepository clienteRepository;

	@RequestMapping("/productos")
	public String home(Model model) {
		model.addAttribute("site_urlport", env.getProperty("site.urlport") );
		//System.out.println( env.getProperty("site.urlport") );

		model.addAttribute("message", "Hola Mundo !!");
		for (Producto p: productoRepository.findAll() ) {
			System.out.println(p.nombre);
		}
		model.addAttribute("productos", productoRepository.findAll());
		return "index";
	}

	@RequestMapping("/cliente")
	public String home2(Model model) {
		model.addAttribute("site_urlport", envc.getProperty("site.urlport") );
		//System.out.println( env.getProperty("site.urlport") );

		model.addAttribute("message", "Hola Mundo !!");
		for (Cliente p: clienteRepository.findAll() ) {
			System.out.println(p.nombre);
		}
		model.addAttribute("cliente", clienteRepository.findAll());
		return "cliente";
	}
		
	@RequestMapping("/")
	public String next(Map<String, Object> model) {
		model.put("message", "Vas muy bien !!!");
		return "next";
	}

}