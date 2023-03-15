package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Inventario;
import com.example.demo.modelo.Producto;
import com.example.demo.service.IInventarioService;
import com.example.demo.service.IProductoService;

@SpringBootApplication
public class RepasoExamen2Application implements CommandLineRunner {

	@Autowired
	private IInventarioService iInventarioService;
	
	@Autowired
	private IProductoService iProductoService;
	
	public static void main(String[] args) {
		SpringApplication.run(RepasoExamen2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("ok");
		
		Producto p = this.iProductoService.buscarPorCodigo("te6");
		System.out.println(p);

		for (Inventario i: p.getListaInventarioProd()) {
			System.out.println(i);
		}
		
	}

}
