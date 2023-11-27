package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
	

}


