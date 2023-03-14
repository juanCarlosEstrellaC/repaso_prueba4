package com.example.demo.repository;

import com.example.demo.modelo.Bodega;

public interface IBodegaRepository {

	public void guardar(Bodega bodega);

	public Bodega buscarPorNumero(String numero);

	public void actualizar(Bodega bod);

}
