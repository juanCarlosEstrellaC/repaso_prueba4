package com.example.demo.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Bodega;
import com.example.demo.modelo.Inventario;
import com.example.demo.modelo.Producto;
import com.example.demo.repository.IInventarioRepository;

@Service
public class InventarioServiceImpl implements IInventarioService{

	@Autowired
	private IInventarioRepository iInventarioRepository;
	
	@Autowired
	private IBodegaService iBodegaService;
	
	@Autowired
	private IProductoService iProductoService;
	
	@Override
	public void guardar(Inventario inventario) {
		
		String numero = inventario.getNumeroBodega();
		String codigo = inventario.getCodigoMaestro();
		Integer cantidad = inventario.getCantidad();
		BigDecimal cantBig = new BigDecimal(cantidad);
		
		Bodega bod = this.iBodegaService.buscarPorNumero(numero);
		Producto pro = this.iProductoService.buscarPorCodigo(codigo);
		
//		inventario.setMiBodega(bod);
//		inventario.setMiProducto(pro);
//		bod.getListaInventarioBode().add(inventario);
//		pro.getListaInventarioProd().add(inventario);
		
		pro.setStock(pro.getStock().add(cantBig));
		
		this.iBodegaService.actualizar(bod);
		this.iProductoService.actualizar(pro);
		
		// En el for debo crear nuevos objetos inventarios para que funcione como pide el profesor.
		// De todas maneras, el codigo que yo hice sí funcionaba, pero no guardaba tantos inventarios, solo uno.
		
		for (int i = 0; i < cantidad; i++) {
			Inventario inv = new Inventario();
			inv.setMiBodega(bod);
			inv.setMiProducto(pro);
			inv.setCantidad(cantidad);
			inv.setCodigoMaestro(codigo);
			inv.setNumeroBodega(numero);
			String codInd = codigo+"_"+i;
			inv.setCodigoIndividual(codInd);
			this.iInventarioRepository.guardar(inv);
		}

	}

	@Override
	public List<Inventario> buscarTodos() {
		return this.iInventarioRepository.buscarTodos();
	}

}
