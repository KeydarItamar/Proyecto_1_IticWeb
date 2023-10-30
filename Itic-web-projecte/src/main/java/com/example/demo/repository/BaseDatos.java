package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.bean.Empresa;

public interface BaseDatos extends JpaRepository<Empresa, Integer> {

}
