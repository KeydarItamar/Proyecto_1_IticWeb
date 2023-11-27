package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.bean.Empresa;

public class EmpresaServiceImpl implements EmpresaService {

	private EmpresaRepository empresaRepository;

	public EmpresaServiceImpl(EmpresaRepository empresaRepository) {
		super();
		this.empresaRepository = empresaRepository;
	}

	@Override
	public List<Empresa> findAll() {
		return (List<Empresa>) this.empresaRepository.findAll();
	}

	@Override
	public Optional<Empresa> findById(int id) {
		// TODO Auto-generated method stub
		return this.empresaRepository.findById(id);
	}

}
