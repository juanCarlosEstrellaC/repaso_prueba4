package com.example.demo.repository;

import com.example.demo.modelo.Inventario;

public interface IInventarioRepository {

	public void guardar(Inventario inventario);
	public void actualizar(Inventario inventario);

}
