package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Bodega;
import com.example.demo.repository.IBodegaRepository;

import jakarta.persistence.Query;

@Service
public class BodegaServiceImpl implements IBodegaService{

	@Autowired
	private IBodegaRepository iBodegaRepository;
	
	@Override
	public void guardar(Bodega bodega) {
		this.iBodegaRepository.guardar(bodega);
	}

	@Override
	public Bodega buscarPorNumero(String numero) {
		return this.iBodegaRepository.buscarPorNumero(numero);
	}

	@Override
	public void actualizar(Bodega bod) {
		this.iBodegaRepository.actualizar(bod);
	}

}
