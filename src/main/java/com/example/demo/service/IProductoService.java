package com.example.demo.service;

import com.example.demo.modelo.Producto;

public interface IProductoService {

	public void guardar(Producto producto);

	public Producto buscarPorCodigo(String codigo);

	public void actualizar(Producto pro);

}
