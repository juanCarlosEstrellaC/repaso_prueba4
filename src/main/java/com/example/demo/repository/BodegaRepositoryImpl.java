package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Bodega;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class BodegaRepositoryImpl implements IBodegaRepository{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void guardar(Bodega bodega) {
		this.entityManager.persist(bodega);
	}

	@Override
	public Bodega buscarPorNumero(String numero) {
		Query query = this.entityManager.createQuery("SELECT b FROM Bodega b WHERE b.numero = :datoNumero");
		query.setParameter("datoNumero", numero);
		return (Bodega)query.getSingleResult();
	}

	@Override
	public void actualizar(Bodega bod) {
		this.entityManager.merge(bod);
	}
	
}
