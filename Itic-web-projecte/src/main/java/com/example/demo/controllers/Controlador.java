package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Empresa;
import com.example.demo.bean.Usuario;
import com.example.demo.repository.BaseDatosService;


@RestController  
@RequestMapping("")
public class Controlador {
	Usuario usuario;
	@Autowired
	BaseDatosService bd;
	
	
	@GetMapping("/")
	public String iniciar(Model model) {
		model.addAttribute("titulo","FORMULARIO DE ACCESO");
		return "login";
	}
	
	@PostMapping("/")
	public String login(Usuario usuario, Model model) {
		if (usuario.getNombre().equals("edu") && usuario.getPassword().equals("edu")) {
			ArrayList<Empresa> empresa = bd.getEmpresas();
			model.addAttribute("usuario",usuario);
			this.usuario = usuario;
			model.addAttribute("empresas", empresa);
			return "consulta";
		} else {
			return "login";
		}
	}

	@GetMapping("/mostrarEmpresas")
	public ArrayList<Empresa> mostrarEmpresa() {	
		ArrayList<Empresa> empresas = bd.getEmpresas();
		return empresas;
		
	}
	
	@PostMapping("/insertar")
	public String insertar (Empresa empresa, Model model) {
		bd.insertar(empresa);
		//bd.save(libro);
		ArrayList<Empresa> empresas =bd.getEmpresas();
		//ArrayList<Libro> libros = (ArrayList <Libro>)bd.findAll();
		model.addAttribute("usuario",this.usuario);
		model.addAttribute("Empresas",empresas);
		model.addAttribute("boton", "Inserta Empresa");
		model.addAttribute("action", "/insertar");
		model.addAttribute("empresa", null);
		return "consulta";
	}
	@GetMapping("/borrado/{id}")
	public String borrar(@PathVariable int id, Model model) {
		bd.borrar(id);
		ArrayList<Empresa> empresas = bd.getEmpresas();
		model.addAttribute("empresas",empresas);
		model.addAttribute("usuario",this.usuario);
		model.addAttribute("boton","Inserta Empresas");
		model.addAttribute("action","/insertar");
		return "consulta";
	}
	@GetMapping("/modificar/{id}")
	public String modificar (@PathVariable int id, Model model) {
		Empresa empresa = bd.getEmpresa(id);
		ArrayList<Empresa> empresas = bd.getEmpresas();
		model.addAttribute("empresas", empresas);
		model.addAttribute("empresa",empresa);
		model.addAttribute("usuario", this.usuario);
		model.addAttribute("boton","Actualiza Empresa");
		model.addAttribute("action", "/modificar");
		return "consulta";
	}
	
	@GetMapping("/modificar/")
	public String modificar2(Empresa empresa, Model model) {
		bd.modificar(empresa);
		ArrayList<Empresa> empresas = bd.getEmpresas();
		model.addAttribute("usuario", this.usuario);
		model.addAttribute("empresas",empresas);
		model.addAttribute("empresa",null);
		model.addAttribute("boton","Inserta Empresa");
		model.addAttribute("action", "/insertar");
		return "consulta";
	}
	
	
	
	
	
	
	
	
	
}