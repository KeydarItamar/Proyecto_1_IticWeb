package com.example.demo.bean;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//Clase empresa, metodos creados: Gette&Setter - Constructor Vacio&Atributos - toString - HashCode - Equals  

@Entity
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
@Table(name="empresas")
public class Empresa {
	private @Id @Column(name="id") @GeneratedValue(strategy=GenerationType.IDENTITY) int id;
	@Column(name="nombre", nullable = false, length = 30)
	@Schema(description = "Nombre identificativo de la emrpesa")
	private String nombre;
	private int telefono;
	@Schema(description ="Correo electrónico de la emrpesa", example = "ejemplo@example.com")
	private String email;
	@Schema(description = "Lista de ofertas laborales que ofrece la empresa")
	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
	private List<Oferta> ofertas;
	
	//constructor vacio y constructor con atributos. 
	
	public Empresa() { super(); }

	public Empresa(int id, String nombre, int telefono, String email,List<Oferta> ofertas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.ofertas = ofertas;
	}

	
	//Getters y setters de los atributos
	
	public List<Oferta> getOfertas() {
		return ofertas;
	}

	public void setOfertas(List<Oferta> ofertas) {
		this.ofertas = ofertas;
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
	
	//Metodos HashCode y equals
	
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
	
	//Metodo toString 
	
	@Override
	public String toString() {
		return "Empresa [id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + ", email=" + email + "]";
	}
}
