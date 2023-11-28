package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.bean.Empresa;

public interface EmpresaService {
	
	List <Empresa> findAll();
	
	Optional <Empresa>findById(int id); 
	
}
