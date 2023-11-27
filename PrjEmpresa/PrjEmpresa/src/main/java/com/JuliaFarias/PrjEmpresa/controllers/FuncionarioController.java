package com.JuliaFarias.PrjEmpresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.JuliaFarias.PrjEmpresa.entities.Funcionario;
import com.JuliaFarias.PrjEmpresa.services.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
	private final FuncionarioService funcionarioService;
	
	@GetMapping
	public String paginaInicial() {
		return "index";
	}
	
	@Autowired
	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}
	
	@PostMapping
	public Funcionario createFuncionario(Funcionario funcionario) {
		return funcionarioService.saveFuncionario(funcionario);
	}
	
	@GetMapping
	public ResponseEntity<List<Funcionario>> getAllFuncionario(RequestEntity<Void> requestEntity) {
		String method = requestEntity.getMethod().name();
		String contentType = requestEntity.getHeaders().getContentType().toString();
		List<Funcionario> funcionario = funcionarioService.getAllFuncionario();
		return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
				.body(funcionario);
	}
	
	@PutMapping("/{id}")
	public Funcionario updateFuncionario(@PathVariable Long id,@RequestBody Funcionario funcionario) {
		return funcionarioService.updateFuncionario(id, funcionario);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> getFuncionario(@PathVariable Long id) {
		Funcionario funcionario = funcionarioService.getFuncionarioById(id);
		if (funcionario != null) {
			return ResponseEntity.ok(funcionario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public void deleteFuncionario(@PathVariable Long id) {
		funcionarioService.deletFuncioario(id);
	}
}