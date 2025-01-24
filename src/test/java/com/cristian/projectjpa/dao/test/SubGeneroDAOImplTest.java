/**
 * 
 */
package com.cristian.projectjpa.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.cristian.projectjpa.dao.SubGeneroDAO;
import com.cristian.projectjpa.dao.impl.SubGeneroDAOImpl;
import com.cristian.projectjpa.entity.Genero;
import com.cristian.projectjpa.entity.SubGenero;

/**
 * @author velas
 * Clase test para comprobar el funcionamiento de los metodos del crud de subgenero
 */
class SubGeneroDAOImplTest {
	
	private SubGeneroDAO subGeneroDao = new SubGeneroDAOImpl();

	/**
	 * Test method for {@link com.cristian.projectjpa.dao.impl.SubGeneroDAOImpl#guardar(com.cristian.projectjpa.entity.SubGenero)}.
	 */
	@Test
	void testGuardar() {
		SubGenero subGenero = new SubGenero();
		subGenero.setDescripcion("Hard Core");
		subGenero.setFechaCreacion(LocalDateTime.now());
		subGenero.setEstatus(true);
		
		Genero genero = new Genero();
		
		genero.setDescripcion("Metal");
		genero.setFechaCreacion(LocalDateTime.now());
		genero.setEstatus(true);
		
		subGenero.setGenero(genero);
		
		this.subGeneroDao.guardar(subGenero);
		
		
	}

	/**
	 * Test method for {@link com.cristian.projectjpa.dao.impl.SubGeneroDAOImpl#actualizar(com.cristian.projectjpa.entity.SubGenero)}.
	 */
	@Test
	void testActualizar() {
		SubGenero subGeneroConsultado = this.subGeneroDao.consultarById(7l);
		
		subGeneroConsultado.setDescripcion("Trash Metal");
		subGeneroConsultado.getGenero().setDescripcion("Metal Trash");
		
		this.subGeneroDao.actualizar(subGeneroConsultado);
	}

	/**
	 * Test method for {@link com.cristian.projectjpa.dao.impl.SubGeneroDAOImpl#eliminar(java.lang.Long)}.
	 */
	@Test
	void testEliminar() {
		
		this.subGeneroDao.eliminar(7l);
		
	}

	/**
	 * Test method for {@link com.cristian.projectjpa.dao.impl.SubGeneroDAOImpl#consultar()}.
	 */
	@Test
	void testConsultar() {
		List<SubGenero> subGenerosConsultados =  this.subGeneroDao.consultar();
		
		assertTrue(subGenerosConsultados.size() > 0);
		
		for (SubGenero subGenero : subGenerosConsultados) {
			System.out.println("subGenero : " + subGenero.getDescripcion());
			System.out.println("Genero : " + subGenero.getGenero().getDescripcion());
			
		}
	}

	/**
	 * Test method for {@link com.cristian.projectjpa.dao.impl.SubGeneroDAOImpl#consultarById(java.lang.Long)}.
	 */
	@Test
	void testConsultarById() {
		fail("Not yet implemented");
	}

}
