package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.Empresa;

@Repository
public interface BaseDatos extends CrudRepository<Empresa, Integer> {

}


