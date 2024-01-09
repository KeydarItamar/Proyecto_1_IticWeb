package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.bean.Empresa;
import com.example.demo.repository.EmpresaRepository;

@SpringBootTest
class GetTestingEmpresa {
	
	@Autowired
	private EmpresaRepository bd;
	
	@Test
	void testGetEmpresaById() {
		Empresa empresa = new Empresa(999, "test", 999999999, "test@gmail.com", null);
		Empresa resultat = bd.save(empresa);
		Empresa empresaGet = bd.findById(resultat.getId()).orElse(null);
		
		assertEquals(resultat, empresaGet);
		
		bd.deleteById(resultat.getId());
	}
	
	@Test
	void testGetAllEmpresas() {
		Empresa empresa = new Empresa(999, "test", 999999999, "test@gmail.com", null);
		ArrayList<Empresa> empresas = (ArrayList<Empresa>) bd.findAll();
		Empresa resultat = bd.save(empresa);
		empresas.add(resultat);
		
		assertEquals(empresas, (ArrayList<Empresa>) bd.findAll());
	
		bd.deleteById(resultat.getId());
	}
	

}
