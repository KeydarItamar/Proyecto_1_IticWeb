package com.example.demo.repository;

import java.util.ArrayList;
import com.example.demo.bean.Empresa;

public interface IBaseDatos {
	
	// Métodos de la base de datos
	
	public void insertar(Empresa empresa);

	public void borrar(int id);
	
	public void modificar(Empresa empresa);
	
	public Empresa getEmpresa(int id);
	
	public ArrayList<Empresa> getEmpresas();
	
	public boolean compruebaUsuario(String usuario, String password);
}
