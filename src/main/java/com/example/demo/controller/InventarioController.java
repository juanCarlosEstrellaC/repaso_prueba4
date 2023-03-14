package com.example.demo.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.Inventario;
import com.example.demo.modelo.Producto;
import com.example.demo.service.IBodegaService;
import com.example.demo.service.IInventarioService;
import com.example.demo.service.IProductoService;

@Controller
@RequestMapping("/inventarios")
public class InventarioController {

	@Autowired
	private IInventarioService iInventarioService;

	
	@GetMapping("/ingresarDatosInventario") // URL:   http://localhost:8080/inventarios/ingresarDatosInventario	
	public String ingresarDatosInventario(Model model, Inventario inventario) {
		model.addAttribute("inventario", inventario);
		return "vistaInventarioIngresoDatos";
	}

	@PostMapping("/guardarDatosInventario")
	public String guardarDatosInventario(Model model, Inventario inventario) {
		model.addAttribute("inventario", inventario);
		
		this.iInventarioService.guardar(inventario);
		return "redirect:/inventarios/ingresarDatosInventario";
	}

}
