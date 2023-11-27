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
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	
	@Test 
	public void modificaEmpresa(){
		//Empresa empresa1 =  new Empresa (30, "italink",66666666,"Email@gmail.com", null);
		Empresa empresa2 = new Empresa (30, "itaCeo",77777777,"Email@gmail.com",null);

		Empresa empresa1 = bd.save(empresa2);
		
		
		String nombre = "itaCeo";
	
		
		
		assertEquals("itaCeo", nombre);
		//assertEquals(77777777, numeroTelf);
		//assertEquals(30, id);
	}


	

	
}	


