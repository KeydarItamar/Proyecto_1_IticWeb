package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.bean.Empresa;
import com.example.demo.repository.EmpresaRepository;

@SpringBootTest
class saveTesting {
	
	@Autowired
	private EmpresaRepository bd;
	
	@Test
	void testGetEmpresaById() {
		Empresa empresa = new Empresa(999, "test", 999999999, "test@gmail.com", null);
		Empresa resultat = bd.save(empresa);
		Empresa empresaGet = bd.findById(resultat.getId()).orElse(null);
		
		assertEquals(resultat, empresaGet);
	}
	
	@Test
	void jkasj() {

		Empresa empresa2 = new Empresa(989, "ahola", 1, "aadeu", null);
		
		Empresa empresa1 = bd.save(empresa2);
		
		int id = empresa1.getId();
		String nom = empresa1.getNombre();
		
		assertEquals(nom, "ahola");
	}
	
	@Test
	void saveAlltest() {
		ArrayList<Empresa> empresas1 = new ArrayList<>(Arrays.asList(
				new Empresa(19, "AmpresaPrueba1", 77777777, "prueba@gmail.com", null),
				new Empresa(20, "Amazon", 66666666, "amazon@gmail.com", null),
				new Empresa(21, "IrisnEng", 888888888, "Iris@gmail.com", null),
				new Empresa(22, "Pasiona", 55555555, "pasiona@gmail.com", null)));

		bd.saveAll(empresas1);
		
		
		Empresa empresaPrueba = bd.findById(22).orElse(null);
		String nom = empresaPrueba.getNombre();
		
		assertEquals(nom, "Pasiona");
	
	}
	
}