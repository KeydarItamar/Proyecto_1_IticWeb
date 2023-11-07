package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Empresa;
import com.example.demo.repository.EmpresaRepository;


@RestController  
@RequestMapping("")
public class EmpresaController {
	@Autowired
	private EmpresaRepository bd; 
	
	@PostMapping("/empresas")
	@ResponseStatus(HttpStatus.CREATED)
	public Empresa newEmpresa(@RequestBody Empresa empresa) {
		Empresa empresa1 = bd.save(empresa);
		return empresa1;
    }
	
	@GetMapping("/empresas")
	public ArrayList<Empresa> getEmpresas() {	
		return (ArrayList<Empresa>) bd.findAll();
	}
	
	@GetMapping("/empresas/{id}")
	public Optional<Empresa> getEmpresaById(@PathVariable int id) {
	    return bd.findById(id);
	}
	
	@PutMapping("/empresas/{id}")
	public Empresa modificaEmpresa(@RequestBody Empresa empresa, @PathVariable int id) {
	    
	    return bd.findById(id)
	      .map(empresa1 -> {
	        empresa1.setNombre(empresa.getNombre());
	        empresa1.setTelefono(empresa.getTelefono());
	        empresa1.setEmail(empresa.getEmail());
	       // empresa1.setId_oferta(empresa.getId_oferta());
	        return bd.save(empresa1);
	      })
	      .orElseGet(() -> {
	        empresa.setId(id);
	        return bd.save(empresa);
	      });
	  }

	@DeleteMapping("/empresas/{id}")
	public void deleteEmpresa(@PathVariable int id) {
		System.out.println("delete");
	    bd.deleteById(id);
	} 	  	
}