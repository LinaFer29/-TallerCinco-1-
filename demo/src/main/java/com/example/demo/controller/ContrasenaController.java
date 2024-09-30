package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Contrasena;
import com.example.demo.repository.ContrasenaRepository;
import com.example.demo.services.ContrasenaService;

@RestController
public class ContrasenaController {
	@Autowired 
	private ContrasenaRepository repository;
	@Autowired
	private ContrasenaService services;
	
	@PostMapping("/contrasena")
	private ResponseEntity<Contrasena> guardarContrasena(@RequestBody Contrasena contrasena){
		Contrasena contra = services.guardarContrasena(contrasena);
		return new ResponseEntity<>(contra,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/user/{id}") 
	private ResponseEntity<Contrasena> leerUsuario (@PathVariable Long id) {
		ResponseEntity<Contrasena> response = services.leerUsuario(id);
		return response;
	}
	
	
	@GetMapping("/users")
	public ResponseEntity<List<Contrasena>> obtenerUsuarios(){
		ResponseEntity<List<Contrasena>> response = services.obtenerUsuarios();
		return response;
	}

	
	@PutMapping("/user/{id}")
	private ResponseEntity<Contrasena> actualizarUsuario(@PathVariable Long id, @RequestBody Contrasena update){
		ResponseEntity<Contrasena> response = services.actualizarUsuario(id,update);
		return response;
		
	}
	
	@DeleteMapping("/user/{id}")
	private ResponseEntity<Contrasena> eliminarUsuario(@PathVariable Long id){
		ResponseEntity<Contrasena> response = services.eliminarUsuario(id);
		return response;
	}
	@PostMapping("/funcion/{dato}")
	private ResponseEntity<String> llamarFuncion(@PathVariable int dato ){
		String response = services.asignarComision(dato);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
