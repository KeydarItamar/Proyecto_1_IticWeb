package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.bean.Empresa;
import com.example.demo.repository.EmpresaRepository;

@SpringBootTest
class PostTestingEmpresa {

	@Autowired
	private EmpresaRepository bd;
	
	@Test 
	public void testPostEmpresaNombre(){
		Empresa empresa1 = new Empresa (999, "itaCeo",77777777,"Email@gmail.com",null);
		Empresa empresa2 = bd.save(empresa1);
		
		assertEquals("itaCeo", empresa2.getNombre());
		
	}
	
	@Test 
	public void testPostEmpresaTelefono(){
		Empresa empresa1 = new Empresa (999, "itaCeo",77777777,"Email@gmail.com",null);
		Empresa empresa2 = bd.save(empresa1);
		
		assertEquals(77777777, empresa2.getTelefono());
		
	}
	
	@Test 
	public void testPostEmpresaEmail(){
		Empresa empresa1 = new Empresa (99, "itaCeo",77777777,"Email@gmail.com",null);
		Empresa empresa2 = bd.save(empresa1);
		
		assertEquals("Email@gmail.com", empresa2.getEmail());
		
	}


	

	
}	


