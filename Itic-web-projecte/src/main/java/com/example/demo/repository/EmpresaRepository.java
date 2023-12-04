package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.Empresa;

import jakarta.transaction.Transactional;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
	
		//Optional <Empresa> findByNombre(String nombre);
		Optional <Empresa> findByTelefono(Integer telefono);
		Optional <Empresa> findByNombreOrderByNombreDesc(String nombre);

		
		
		@Query(value = """
		        SELECT CASE WHEN COUNT(e) > 0 THEN true ELSE false END
		        FROM Empresa e
		        WHERE lower(e.nombre) LIKE lower(:nombre)
		        """)
		boolean existsEmpresaByNombre(String nombre);
		
		
		
		@Query(value = "UPDATE Empresa e set e.telefono = 11111111 where e.telefono = :telefono")
		@Transactional
		@Modifying
		void updateEmpresaTelefonoByNewTelefono(int telefono);



		
}



