package com.example.demo.controller;

import com.example.demo.model.Admin;
import com.example.demo.model.Cliente;
import com.example.demo.model.Empleado;
import com.example.demo.model.Pedidos;
import com.example.demo.model.Producto;
import com.example.demo.model.Proveedores;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.EmpleadoRepository;
import com.example.demo.repository.PedidoRepository;
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
        @Autowired
        private Environment envped;
        @Autowired
        PedidoRepository pedidoRepository;
        @Autowired
        private Environment envad;
        @Autowired
        AdminRepository adminRepository;
         @Autowired
        private Environment envemp;
        @Autowired
        EmpleadoRepository empleadoRepository;

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
        
        @RequestMapping("/pedido")
	public String home4(Model model) {
		model.addAttribute("site_urlport", envped.getProperty("site.urlport") );
		//System.out.println( env.getProperty("site.urlport") );

		model.addAttribute("message", "PEDIDOS");
                
		for (Pedidos p: pedidoRepository.findAll() ) {
			System.out.println(p.concepto);
		}
		model.addAttribute("pedido", pedidoRepository.findAll());
		return "pedido";
        }
         @RequestMapping("/admin")
	public String home5(Model model) {
		model.addAttribute("site_urlport", envad.getProperty("site.urlport") );
		//System.out.println( env.getProperty("site.urlport") );

		model.addAttribute("message", "ADMINISTRADORES");
                
		for (Admin p: adminRepository.findAll() ) {
			System.out.println(p.nombre);
		}
		model.addAttribute("admin", adminRepository.findAll());
		return "admin";
        }
        @RequestMapping("/empleado")
	public String home6(Model model) {
		model.addAttribute("site_urlport", envemp.getProperty("site.urlport") );
		//System.out.println( env.getProperty("site.urlport") );

		model.addAttribute("message", "ADMINISTRADORES");
                
		for (Empleado p: empleadoRepository.findAll() ) {
			System.out.println(p.nombre);
		}
		model.addAttribute("empleado", empleadoRepository.findAll());
		return "empleado";
        }
		
	@RequestMapping("/")
	public String next(Map<String, Object> model) {
		model.put("message", "Vas muy bien !!!");
		return "next";
	}
        
}