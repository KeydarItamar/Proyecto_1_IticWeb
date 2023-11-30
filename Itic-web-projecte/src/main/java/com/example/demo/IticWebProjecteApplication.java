package com.example.demo;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.bean.Empresa;
import com.example.demo.repository.EmpresaRepository;

@SpringBootApplication
public class IticWebProjecteApplication {

	public static void main(String[] args) {
		//SpringApplication.run(IticWebProjecteApplication.class, args);
	
	
		//context crea todas las estructuras de las funciones vacias del repository
		ApplicationContext context = SpringApplication.run(IticWebProjecteApplication.class,args);
		var repo = context.getBean(EmpresaRepository.class);
	
		
		Empresa empresa1 = new Empresa (89,"prueba",123456789,"prueba@gmail.com", null);
		repo.save(empresa1);
		
		System.out.println(empresa1.getTelefono());
		repo.updateEmpresaTelefonoByNewTelefono(123456789);
	
		
		empresa1 = repo.findById(empresa1.getId()).orElse(null);
		
		if (empresa1 != null) {
			System.out.println(empresa1.getTelefono());
		}else {
			System.out.println("Esta vacio");
		}
		
		
		boolean existe = repo.existsEmpresaByNombre("prueba");
		
				
		if (existe) {
			System.out.println("Existe la empresa llamada: prueba");
		}else {
			System.out.println("algo ha fallado o no existe");
		}
		//repo.findByNameOrderByNombreDesc(null);
		
		
		Optional <Empresa> empresa2 = repo.findByTelefono(11111111);
		System.out.println(empresa2.toString());

	}

}
