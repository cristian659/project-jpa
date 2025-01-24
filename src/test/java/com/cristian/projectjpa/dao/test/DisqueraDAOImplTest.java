/**
 * 
 */
package com.cristian.projectjpa.dao.test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.cristian.projectjpa.dao.DisqueraDAO;
import com.cristian.projectjpa.dao.impl.DisqueraDAOImpl;
import com.cristian.projectjpa.entity.Disquera;

/**
 * @author velas
 *
 */
class DisqueraDAOImplTest {
	
	private DisqueraDAO disqueraDAO = new DisqueraDAOImpl();

	/**
	 * Test method for {@link com.cristian.projectjpa.dao.impl.DisqueraDAOImpl#guardar(com.cristian.projectjpa.entity.Disquera)}.
	 */
	@Test
	void testGuardar() {
		Disquera disquera = new Disquera();
		disquera.setDescripcion("Electrik");
		disquera.setFechaCreacion(LocalDateTime.now());
		disquera.setEstatus(true);
		
		this.disqueraDAO.guardar(disquera);
		
	}

	/**
	 * Test method for {@link com.cristian.projectjpa.dao.impl.DisqueraDAOImpl#actualizar(com.cristian.projectjpa.entity.Disquera)}.
	 */
	@Test
	void testActualizar() {
		Disquera disqueraConsultada = this.disqueraDAO.consultarById(9l);
		
		disqueraConsultada.setDescripcion("Disquera IronMaiden");
		
		this.disqueraDAO.actualizar(disqueraConsultada);
	}

	/**
	 * Test method for {@link com.cristian.projectjpa.dao.impl.DisqueraDAOImpl#eliminar(com.cristian.projectjpa.entity.Disquera)}.
	 */
	@Test
	void testEliminar() {
		Long id = 9l;
		
		this.disqueraDAO.eliminar(id);
	}

	/**
	 * Test method for {@link com.cristian.projectjpa.dao.impl.DisqueraDAOImpl#consultar()}.
	 */
	@Test
	void testConsultar() {
		List<Disquera> disqueraConsultadas = this.disqueraDAO.consultar();
		
		assertTrue(disqueraConsultadas.size() > 0); //valida si viene vacia y si viene vacia la retorna como nulo
		
		disqueraConsultadas.forEach(disquera -> { // SE USA UNA FUNCION LAMDA PARA PODER RECORRER TODOS LOS DATOS DEL FOR EACH de disquera
			System.out.println("Disquera: " + disquera.getDescripcion());
		});
		
		
	}

	/**
	 * Test method for {@link com.cristian.projectjpa.dao.impl.DisqueraDAOImpl#consultarById(java.lang.Long)}.
	 */
	@Test
	void testConsultarById() {
		Disquera disquera = this.disqueraDAO.consultarById(9l);
		System.out.println("Disquera: "+ disquera.getDescripcion());
	}

}
