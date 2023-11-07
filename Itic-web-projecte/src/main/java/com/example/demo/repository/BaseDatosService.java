package com.example.demo.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Empresa;

@Service
public class BaseDatosService implements IBaseDatos {
	
	@Autowired
	EmpresaRepository bd;
	
	// Añadir Empresa
	
	@Override
	public void insertar(Empresa empresa) {
		bd.save(empresa); }
	
	
	// Borrar Empresa
	
	@Override
	public void borrar(int id) { bd.deleteById(id); }
	
	// Modificar Empresa
	
	@Override
	public void modificar(Empresa empresa) {
		bd.save(empresa); 
		}
	
	// Consultar Empresa
	
	@Override
	public Empresa getEmpresa(int id) { 
		Optional<Empresa> l = bd.findById(id);
		return l.get();
	}
	
	// Consultar todas las emprseas
	
	@Override
	public ArrayList<Empresa> getEmpresas() {
		return (ArrayList<Empresa>) bd.findAll();
		}
	
	// Comprobar si el usuario existe
	
	@Override
	public boolean compruebaUsuario(String usuario, String password) { 
		boolean check = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String conex = "jdbc.mysql://localhost:3306/empresas";
			Connection conexion = DriverManager.getConnection(conex, "root", "");
			Statement s = conexion.createStatement();
			String sql = "SELECT count(*) FROM USUARIOS WHERE usuario='"+usuario+"' "
					+ "and password0='"+password+"'";
			s.execute(sql);
			ResultSet rs = s.getResultSet();
			rs.next();
			if (rs.getInt(1)>0)
				check = true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return check;
	}
}
