package com.example.demo.service;

import com.example.demo.modelo.Bodega;

public interface IBodegaService {

	public void guardar(Bodega bodega);

	public Bodega buscarPorNumero(String numero);

	public void actualizar(Bodega bod);

}
