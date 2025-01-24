/**
 * 
 */
package com.cristian.projectjpa.dao.impl;

import java.util.List;

import com.cristian.projectjpa.dao.DisqueraDAO;
import com.cristian.projectjpa.entity.Disquera;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

/**
 * @author velas CLASE QUE IMPLEMENTA LAS TRANSACCIONES PARA LA TABLA DE
 *         DISQUERA
 */
public class DisqueraDAOImpl implements DisqueraDAO {

	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("persistenceCristian");

	@Override
	public void guardar(Disquera disquera) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		EntityTransaction et = em.getTransaction(); // PARA HACER una transaccion que afecte a la base de datos
		et.begin();// permite decir que inicia la transaccion para que permita guardar informacion
					// en la base de datos

		try {
			em.persist(disquera);// permite guardar la informacion de una entidad en la base de datos
			et.commit(); // asegura que si se hizo un insert ya quedo hecho
		} catch (Exception e) {
			// TODO: handle exception
			if (et != null) {
				et.rollback();// regresar ese inser y que no se mantenga la informacion en la tabla
			}
			e.printStackTrace();
		} finally {
			em.close();// para que siempre cierre la conexion a la bd
		}

	}

	@Override
	public void actualizar(Disquera disquera) {
		// TODO Auto-generated method stub
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		EntityTransaction et = em.getTransaction(); // PARA HACER una transaccion que afecte a la base de datos
		et.begin();// permite decir que inicia la transaccion para que permita guardar informacion
					// en la base de datos

		try {
			em.merge(disquera);// permite actualizar la informacion de una entidad en la base de datos
			et.commit(); // asegura que si se hizo un insert ya quedo hecho
		} catch (Exception e) {
			// TODO: handle exception
			if (et != null) {
				et.rollback();// regresar ese inser y que no se mantenga la informacion en la tabla
			}
			e.printStackTrace();
		} finally {
			em.close();// para que siempre cierre la conexion a la bd
		}

	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		Disquera disqueraConsultada = em.find(Disquera.class, id);

		EntityTransaction et = em.getTransaction(); // PARA HACER una transaccion que afecte a la base de datos
		et.begin();// permite decir que inicia la transaccion para que permita guardar informacion
					// en la base de datos

		try {
			em.remove(disqueraConsultada);// permite guardar la informacion de una entidad en la base de datos
			et.commit(); // asegura que si se hizo un insert ya quedo hecho
		} catch (Exception e) {
			// TODO: handle exception
			if (et != null) {
				et.rollback();// regresar ese inser y que no se mantenga la informacion en la tabla
			}
			e.printStackTrace();
		} finally {
			em.close();// para que siempre cierre la conexion a la bd
		}

	}

	@Override
	public List<Disquera> consultar() {
		// TODO Auto-generated method stub
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		TypedQuery<Disquera> queryDisquera =  (TypedQuery<Disquera>) em.createQuery("FROM Disquera ORDER BY descripcion");
		
		return queryDisquera.getResultList();
		
	}

	@Override
	public Disquera consultarById(Long id) {
		// TODO Auto-generated method stub
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		Disquera disqueraConsultado = em.find(Disquera.class, id); // es para buscar por la clase y por el id

		if (disqueraConsultado == null) {
			throw new EntityNotFoundException("La disquera con id " + id + " no se encontro");
		}

		return disqueraConsultado;
	}

}
