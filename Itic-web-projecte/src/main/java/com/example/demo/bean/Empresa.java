package com.example.demo.bean;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//Clase empresa, metodos creados: Gette&Setter - Constructor Vacio&Atributos - toString - HashCode - Equals  

@Entity
@Table(name="empresas")
public class Empresa {
	private @Id @Column(name="id") @GeneratedValue(strategy=GenerationType.IDENTITY) int id;
	@Column(name="nombre", nullable = false, length = 30)
	private String nombre;
	private int telefono;
	private String email;
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Oferta oferta;
	
	
	
	
	
	//constructo vacio y constructor con atributos. 

	public Empresa() {
		
	}

	
	public Empresa(int id, String nombre, int telefono, String email,Oferta oferta) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.oferta = oferta;
	}
	//Getters y settes de los atributos: 
	
	public Oferta getId_oferta() {
		return oferta;
	}


	public void setId_oferta(Oferta oferta) {
		this.oferta = oferta;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	//Metodo to String 
	
	@Override
	public String toString() {
		return "Empresa [id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + ", email=" + email + "]";
	}


	
	//Metodos Hashcode y equals. 
	
	@Override
	public int hashCode() {
		return Objects.hash(email, id, nombre, telefono);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && telefono == other.telefono;
	}


/*	public Object map(Empresa empresa) {
		return empresa;
	}
	*/
	
	
	
	
}
