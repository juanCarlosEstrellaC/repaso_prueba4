package com.example.demo.repository;

import com.example.demo.modelo.Producto;

public interface IProductoRepository {

	public void guardar(Producto producto);

	public Producto buscarPorCodigo(String codigo);

}
