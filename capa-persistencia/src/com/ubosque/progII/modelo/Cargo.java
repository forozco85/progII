package com.ubosque.progII.modelo;

import java.io.Serializable;
import javax.persistence.*;

import org.eclipse.persistence.annotations.ReturnInsert;


/**
 * The persistent class for the CARGO database table.
 * 
 */
@Entity
@NamedQuery(name="Cargo.findAll", query="SELECT c FROM Cargo c")
public class Cargo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@ReturnInsert(returnOnly = true)
	@Column(name="CARGO_ID")
	private long cargoId;

	private String nombrecargo;

	public Cargo() {
	}

	public long getCargoId() {
		return this.cargoId;
	}

	public void setCargoId(long cargoId) {
		this.cargoId = cargoId;
	}

	public String getNombrecargo() {
		return this.nombrecargo;
	}

	public void setNombrecargo(String nombrecargo) {
		this.nombrecargo = nombrecargo;
	}

}