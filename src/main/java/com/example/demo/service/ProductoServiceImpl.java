package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Bodega;
import com.example.demo.modelo.Producto;
import com.example.demo.repository.IBodegaRepository;
import com.example.demo.repository.IProductoRepository;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoRepository iProductoRepository;
	
	@Override
	public void guardar(Producto producto) {
		this.iProductoRepository.guardar(producto);
	}

	@Override
	public Producto buscarPorCodigo(String codigo) {
		return this.iProductoRepository.buscarPorCodigo(codigo);
	}

	@Override
	public void actualizar(Producto pro) {
		this.iProductoRepository.actualizar(pro);
	}

}
