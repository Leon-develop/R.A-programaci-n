package com.example.demo.controller;

import com.example.demo.model.Cliente;
import com.example.demo.model.Producto;
import com.example.demo.model.Proveedores;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.repository.ProveedoresRepository;
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
         @Autowired
        private Environment envpr;
        @Autowired
        ProveedoresRepository proveedoresRepository;
         

	@RequestMapping("/productos")
	public String home(Model model) {
		model.addAttribute("site_urlport", env.getProperty("site.urlport") );
		//System.out.println( env.getProperty("site.urlport") );

		model.addAttribute("message", "PRODUCTOS");
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

		model.addAttribute("message", "CLIENTES");
		for (Cliente p: clienteRepository.findAll() ) {
			System.out.println(p.nombre);
		}
		model.addAttribute("cliente", clienteRepository.findAll());
		return "cliente";
                
	}
        @RequestMapping("/proveedor")
	public String home3(Model model) {
		model.addAttribute("site_urlport", envpr.getProperty("site.urlport") );
		//System.out.println( env.getProperty("site.urlport") );

		model.addAttribute("message", "PROVEEDORES");
                
		for (Proveedores p: proveedoresRepository.findAll() ) {
			System.out.println(p.nombre);
		}
		model.addAttribute("proveedor", proveedoresRepository.findAll());
		return "proveedor";
        }
		
	@RequestMapping("/")
	public String next(Map<String, Object> model) {
		model.put("message", "Vas muy bien !!!");
		return "next";
	}

}