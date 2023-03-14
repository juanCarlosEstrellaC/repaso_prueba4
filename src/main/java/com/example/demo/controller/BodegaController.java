package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.Bodega;
import com.example.demo.service.IBodegaService;

@Controller
@RequestMapping("/bodegas")
public class BodegaController {

	@Autowired
	private IBodegaService iBodegaService;
	
	@GetMapping("/ingresarDatosBodega") // URL:   http://localhost:8080/bodegas/ingresarDatosBodega	
	public String ingresarDatosBodega(Model model, Bodega bodega) {
		model.addAttribute("bodega", bodega);
		return "vistaBodegaIngresoDatos";
	}

	@PostMapping("/guardarDatosBodega")
	public String guardarDatosBodega(Model model, Bodega bodega) {
		model.addAttribute("bodega", bodega);
		this.iBodegaService.guardar(bodega);
		return "redirect:/bodegas/ingresarDatosBodega";
	}

}
