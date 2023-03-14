package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Bodega;
import com.example.demo.modelo.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void guardar(Producto producto) {
		this.entityManager.persist(producto);
	}

	@Override
	public Producto buscarPorCodigo(String codigo) {
		Query query = this.entityManager.createQuery("SELECT p FROM Producto p WHERE p.codigo = :datoCodigo");
		query.setParameter("datoCodigo", codigo);
		return (Producto)query.getSingleResult();
	}

}
