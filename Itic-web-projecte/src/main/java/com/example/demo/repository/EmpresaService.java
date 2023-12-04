package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.bean.Empresa;

@Service
public interface EmpresaService {
	
	List <Empresa> findAll();
	
	Optional <Empresa>findById(int id); 
	
}
