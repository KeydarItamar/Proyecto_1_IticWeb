package com.example.demo;
import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.bean.Empresa;
import com.example.demo.repository.EmpresaRepository;
import com.example.demo.repository.EmpresaService;
import com.example.demo.repository.EmpresaServiceImpl;


class EmpresaServiceImpleTest {


	EmpresaService empresaService;
	
	@Mock
	EmpresaRepository empresaRepository;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		empresaService = new EmpresaServiceImpl(empresaRepository);	
	}
	
	@Test
	void findAll() {
		when(empresaRepository.findAll()).thenReturn(List.of());
	
		List <Empresa> empresas = empresaService.findAll();
		
		assertNotNull(empresas);	
	}

	@Test
	void findById() {
		when(empresaRepository.findById((int)1L)).thenReturn(Optional.of(new Empresa()));
		
		Optional<Empresa> empresa = empresaService.findById((int) 1L);
		
		assertNotNull(empresa);
	}

}
