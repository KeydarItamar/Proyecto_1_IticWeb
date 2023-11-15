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

import com.example.demo.bean.Oferta;
import com.example.demo.repository.OfertasRepository;


@RestController  
@RequestMapping("/oferta")
public class OfertasController {

		@Autowired
		private OfertasRepository bd; 
		
		@PostMapping("/ofertas")
		@ResponseStatus(HttpStatus.CREATED)
		public Oferta newoferta(@RequestBody Oferta oferta) {
			Oferta oferta1 = bd.save(oferta);
			return oferta1;
	    }
		
		@GetMapping("/ofertas")
		public ArrayList<Oferta> getofertas() {	
			return (ArrayList<Oferta>) bd.findAll();
		}
		
		@GetMapping("/ofertas/{id}")
		public Optional<Oferta> getofertaById(@PathVariable int id) {
		    return bd.findById(id);
		}
		
		@PutMapping("/ofertas/{id}")
		public Oferta modificaoferta(@RequestBody Oferta oferta, @PathVariable int id) {
		    
		    return bd.findById(id)
		      .map(oferta1 -> {
		        oferta1.setSalario(oferta.getSalario());
		        oferta1.setDescripcion(oferta.getDescripcion());
		        oferta1.setRequisitos(oferta.getRequisitos());
		        return bd.save(oferta1);
		      })
		      .orElseGet(() -> {
		        oferta.setId(id);
		        return bd.save(oferta);
		      });
		  }

		@DeleteMapping("/ofertas/{id}")
		public void deleteoferta(@PathVariable int id) {
			System.out.println("delete");
		    bd.deleteById(id);
		} 	  	
}
	
	

	
