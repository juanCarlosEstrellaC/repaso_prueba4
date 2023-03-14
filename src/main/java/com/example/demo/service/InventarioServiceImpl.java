package com.example.demo.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Bodega;
import com.example.demo.modelo.Inventario;
import com.example.demo.modelo.Producto;
import com.example.demo.repository.IBodegaRepository;
import com.example.demo.repository.IInventarioRepository;
import com.example.demo.repository.IProductoRepository;

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
		BigDecimal cantidad = inventario.getCantidad();
		
		Bodega bod = this.iBodegaService.buscarPorNumero(numero);
		Producto pro = this.iProductoService.buscarPorCodigo(codigo);
		
		bod.getListaInventarioBode().add(inventario);
		this.iBodegaService.actualizar(bod);
		
//		for (int i = 0; i < cantidad.longValue(); i++) {
//			String codInd = codigo+"_"+i;
//			this.iInventarioRepository.guardar(inventario);
//
//		}

	}

}
