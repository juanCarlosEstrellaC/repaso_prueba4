package com.example.demo.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.Bodega;
import com.example.demo.modelo.Producto;
import com.example.demo.service.IProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private IProductoService iProductoService;
	
	@GetMapping("/ingresarDatosProducto") // URL:   http://localhost:8080/productos/ingresarDatosProducto	
	public String ingresarDatosBodega(Model model, Producto producto) {
		model.addAttribute("producto", producto);
		return "vistaProductoIngresoDatos";
	}

	@PostMapping("/guardarDatosProducto")
	public String guardarDatosBodega(Model model, Producto producto) {
		model.addAttribute("producto", producto);
		producto.setStock(new BigDecimal(0));
		this.iProductoService.guardar(producto);
		return "redirect:/productos/ingresarDatosProducto";
	}

}
