package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.bean.Empresa;
import com.example.demo.repository.EmpresaRepository;

@SpringBootApplication
public class IticWebProjecteApplication {

	public static void main(String[] args) {
		SpringApplication.run(IticWebProjecteApplication.class, args);

		ApplicationContext context = SpringApplication.run(EmpresaRepository.class,args);
		var repo = context.getBean(EmpresaRepository.class);
		
		Empresa empresa1 = new Empresa (89,"prueba",123456789,"prueba@gmail.com", null);
		
		repo.save(empresa1);
		
		System.out.println(empresa1.getTelefono());
		repo.updateEmpresaTelefonoByNewTelefono(123456789);
		
		//repo.existsEmpresaByNombre(null);
		//repo.findByNameOrderByNombreDesc(null);
		
		
		System.out.println(empresa1.getTelefono());

	}

}
