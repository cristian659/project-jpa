/**
 * 
 */
package com.cristian.projectjpa.dao.impl;

import java.util.List;

import com.cristian.projectjpa.dao.SubGeneroDAO;
import com.cristian.projectjpa.entity.SubGenero;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

/**
 * @author velas Clase que implementa el CRUD para las transacciones a la tabla
 *         de subgenero
 */
public class SubGeneroDAOImpl implements SubGeneroDAO {

	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("persistenceCristian");

	@Override
	public void guardar(SubGenero subGenero) {
		// TODO Auto-generated method stub
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		EntityTransaction et = em.getTransaction();

		try {
			et.begin();

			em.persist(subGenero);

			et.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if (et != null) {
				et.rollback();
			}

			e.printStackTrace();
		} finally {
			em.close();
		}

	}

	@Override
	public void actualizar(SubGenero subGenero) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		EntityTransaction et = em.getTransaction();

		try {
			et.begin();

			em.merge(subGenero);

			et.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if (et != null) {
				et.rollback();
			}

			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	@Override
	public void eliminar(Long id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		SubGenero subGeneroConsultado = em.find(SubGenero.class, id);

		EntityTransaction et = em.getTransaction();

		try {
			et.begin();

			em.remove(subGeneroConsultado);

			et.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if (et != null) {
				et.rollback();
			}

			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	@Override
	public List<SubGenero> consultar() {
		// TODO Auto-generated method stub
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		TypedQuery<SubGenero> queryTyped = (TypedQuery<SubGenero>) em
				.createQuery("FROM SubGenero ORDER BY descripcion");
		return queryTyped.getResultList();
	}

	@Override
	public SubGenero consultarById(Long id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		return em.find(SubGenero.class, id);
	}

}
