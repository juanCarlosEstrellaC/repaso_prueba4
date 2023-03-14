package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Inventario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class InventarioRepositoryImpl implements IInventarioRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void guardar(Inventario inventario) {
		this.entityManager.persist(inventario);
	}

	@Override
	public void actualizar(Inventario inventario) {
		this.entityManager.merge(inventario);
	}

	
}
