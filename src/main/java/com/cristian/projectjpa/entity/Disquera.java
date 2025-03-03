/**
 * 
 */
package com.cristian.projectjpa.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author velas 
 * Clase que repesenta el entity qye mapea la tabla de disquea de JPA
 */
@Entity
@Table(name = "disquera")
public class Disquera {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDisquera")
	private Long idDisquera;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "fechaCreacion")
	private LocalDateTime fechaCreacion;

	@Column(name = "fechaModificacion")
	private LocalDateTime fechaModificacion;

	@Column(name = "estatus")
	private boolean estatus;

	/**
	 * @return the idDisquera
	 */
	public Long getIdDisquera() {
		return idDisquera;
	}

	/**
	 * @param idDisquera the idDisquera to set
	 */
	public void setIdDisquera(Long idDisquera) {
		this.idDisquera = idDisquera;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the fechaCreacion
	 */
	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * @return the fechaModificacion
	 */
	public LocalDateTime getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(LocalDateTime fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * @return the estatus
	 */
	public boolean isEstatus() {
		return estatus;
	}

	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

}
