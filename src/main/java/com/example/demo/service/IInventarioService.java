package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Inventario;

public interface IInventarioService {

	public void guardar(Inventario inventario);

	public List<Inventario> buscarTodos();

}
