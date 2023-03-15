package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.Inventario;
import com.example.demo.service.IInventarioService;

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

	@GetMapping("/VerTodosInventario") // URL:   http://localhost:8080/inventarios/VerTodosInventario	
	public String VerTodosInventario(Model model) {
		List<Inventario> listaInv = this.iInventarioService.buscarTodos();
		model.addAttribute("listaInv", listaInv);
		return "vistaInventarioTodos";
	}
}
