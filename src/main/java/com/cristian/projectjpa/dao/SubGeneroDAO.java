/**
 * 
 */
package com.cristian.projectjpa.dao;

import java.util.List;

import com.cristian.projectjpa.entity.SubGenero;

/**
 * @author velas
 * Interface que genera el DAO para las transacciones del CRUD a la tabla de SubGenero
 */
public interface SubGeneroDAO {
	
	/**
	 * Metodo que permite guardar un subgenero
	 * @param Subgenero {@link SubGenero} objeto a guardar
	 */
	
	void guardar(SubGenero subGenero);
	
	/**
	 * Metodo que permite actualizar un subgenero
	 * @param Subgenero {@link SubGenero} objeto a actualizar
	 */
	
	void actualizar(SubGenero subGenero);
	
	/**
	 * Metodo que permite eliminar un subgenero por su identificador
	 * @param Subgenero {@link Long} identificador del objeto a eliminar
	 */
	
	void eliminar(Long id);
	
	/**
	 * Metodo que permite consultar la lista de subgeneros
	 * @param Subgenero {@link List} Lista de subgeneros consultados
	 */
	List<SubGenero> consultar();
	
	/**
	 * Metodo que permite consultar un subgenero por su identificador
	 * @param Subgenero {@link Long} identificador del objeto a consultar
	 */
	SubGenero consultarById(Long id);

}
