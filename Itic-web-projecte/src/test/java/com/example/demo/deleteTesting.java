package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.bean.Empresa;
import com.example.demo.bean.Oferta;
import com.example.demo.repository.EmpresaRepository;
import com.example.demo.repository.OfertasRepository;


@SpringBootTest
public class deleteTesting {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private OfertasRepository ofertaRepository;

    private Empresa empresa;

    @BeforeEach
    public void setUp() {
        empresa = new Empresa();
        empresa.setNombre("Empresa de Prueba");
        empresa.setTelefono(123456789);
        empresa.setEmail("empresa@prueba.com");

        // Guardar la empresa para poder usarla en las pruebas
        empresaRepository.save(empresa);
        
        Oferta oferta = new Oferta();
        oferta.setDescripcion("Oferta 1");
        oferta.setRequisitos("Requisitos 1");
        oferta.setSalario(50000.0);
        oferta.setEmpresa(empresa);
        
        // Guardar la oferta para poder usarla en las pruebas
        ofertaRepository.save(oferta);
    }

    @Test
    public void testDeleteById() {
        int id = empresa.getId();

        empresaRepository.deleteById(id);

        Optional<Empresa> empresaOptional = empresaRepository.findById(id);
        assertFalse(empresaOptional.isPresent(), "La empresa debe ser eliminada");
    }
    
    @Test
    public void testDelete() {
    	// Cargar las ofertas asociadas a la empresa
        empresa = empresaRepository.findById(empresa.getId()).orElseThrow();

        // Eliminar la empresa y sus ofertas
        empresaRepository.delete(empresa);

        Optional<Empresa> empresaOptional = empresaRepository.findById(empresa.getId());
        assertFalse(empresaOptional.isPresent(), "La empresa debe ser eliminada");
    }
    

    @Test
    public void testDeleteAllById() {
        // Puedes crear más empresas de prueba si es necesario
        Empresa otraEmpresa = new Empresa();
        otraEmpresa.setNombre("Otra Empresa");
        otraEmpresa.setTelefono(987654321);
        otraEmpresa.setEmail("otra@empresa.com");
        empresaRepository.save(otraEmpresa);

        List<Integer> ids = List.of(empresa.getId(), otraEmpresa.getId());

        empresaRepository.deleteAllById(ids);

        assertFalse(empresaRepository.findById(empresa.getId()).isPresent(), "La primera empresa debe ser eliminada");
        assertFalse(empresaRepository.findById(otraEmpresa.getId()).isPresent(), "La otra empresa debe ser eliminada");
    }
    
    @Test
    public void testDeleteAll() {
        Empresa otraEmpresa = new Empresa();
        otraEmpresa.setNombre("Otra Empresa");
        otraEmpresa.setTelefono(987654321);
        otraEmpresa.setEmail("otra@empresa.com");
        empresaRepository.save(otraEmpresa);

        empresaRepository.deleteAll();

        assertTrue(((List) empresaRepository.findAll()).isEmpty(), "Todas las empresas deben ser eliminadas");
    }
	
}