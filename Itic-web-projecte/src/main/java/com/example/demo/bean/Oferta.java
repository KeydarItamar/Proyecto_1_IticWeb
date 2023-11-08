package com.example.demo.bean;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="ofertas")
public class Oferta {
 private@Id @Column(name="id") @GeneratedValue(strategy=GenerationType.IDENTITY) int id;
	@Column(name="descripcion", nullable = false, length = 300)
 private String descripcion;
 private String requisitos;
 @ManyToOne()
 @JoinColumn(name = "empresa_id")
 private Empresa empresa;
 private double salario;
 

public Oferta(int id, String descripcion, String requisitos, double salario, Empresa empresa) {
	super();
	this.id = id;
	this.descripcion = descripcion;
	this.requisitos = requisitos;
	this.salario = salario;
	this.empresa = empresa;
}

public Oferta() {
	super();
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public String getRequisitos() {
	return requisitos;
}
public void setRequisitos(String requisitos) {
	this.requisitos = requisitos;
}


//public int getId_empresa() {
	//return id_empresa;
//}

//public void setId_empresa(int id_empresa) {
	//this.id_empresa = id_empresa;
//}

public double getSalario() {
	return salario;
}
public void setSalario(double salario) {
	this.salario = salario;
}

@Override
public int hashCode() {
	return Objects.hash(descripcion, id, requisitos, salario);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Oferta other = (Oferta) obj;
	return Objects.equals(descripcion, other.descripcion) && id == other.id
			&& Objects.equals(requisitos, other.requisitos)
			&& Double.doubleToLongBits(salario) == Double.doubleToLongBits(other.salario);
}


@Override
public String toString() {
	return "Ofertas [id=" + id + ", descripcion=" + descripcion + ", requisitos=" + requisitos + ", salario=" + salario
			+ "]";
}
 
 
}
