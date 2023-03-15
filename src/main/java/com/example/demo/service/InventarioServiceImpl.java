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
		BigDecimal cantidad = inventario.getCantidad();
		
		Bodega bod = this.iBodegaService.buscarPorNumero(numero);
		Producto pro = this.iProductoService.buscarPorCodigo(codigo);
		
//		List<Inventario> l = new ArrayList<>();
//		l.add(inventario);
//		
//		bod.setListaInventarioBode(l);
//		pro.setListaInventarioProd(l);
		
		
		inventario.setMiBodega(bod);
		inventario.setMiProducto(pro);
		bod.getListaInventarioBode().add(inventario);
		pro.getListaInventarioProd().add(inventario);
		
		this.iBodegaService.actualizar(bod);
		this.iProductoService.actualizar(pro);
		
		
		for (int i = 0; i < 5; i++) {
			String codInd = codigo+"_"+i;
			inventario.setCodigoIndividual(codInd);
			this.iInventarioRepository.guardar(inventario);
		}

	}

	@Override
	public List<Inventario> buscarTodos() {
		return this.iInventarioRepository.buscarTodos();
	}

}
