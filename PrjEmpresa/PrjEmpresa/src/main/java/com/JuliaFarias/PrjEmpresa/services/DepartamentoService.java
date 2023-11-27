package com.JuliaFarias.PrjEmpresa.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.JuliaFarias.PrjEmpresa.entities.Departamento;
import com.JuliaFarias.PrjEmpresa.repositories.DepartamentoRepository;

@Service
public class DepartamentoService {
	private final DepartamentoRepository departamentoRepository;

	@Autowired
	public DepartamentoService(DepartamentoRepository departamentoRepository) {
		this.departamentoRepository = departamentoRepository;
	}
	
	public Departamento saveDepartamento(Departamento departamento) {
		return departamentoRepository.save(departamento);
	}
	
	public Departamento getDepartamentoById(Long id) {
		return departamentoRepository.findById(id).orElse(null);
	}
	
	public Departamento getDepartamentoById(long id) {
		return departamentoRepository.findById(id).orElse(null);
	}
	
	public List<Departamento> getAllDepartamento(){
		return departamentoRepository.findAll();
	}
	
	public void deletDepartamento(Long id) {
		departamentoRepository.deleteById(id);
	}
	
	public Departamento updateDepartamento(Long id, Departamento novoDepartamento) {
		Optional<Departamento> departamentoOptional = departamentoRepository.findById(id);
		
	    if (departamentoOptional.isPresent()) {
	    	Departamento departamentoExistente = departamentoOptional.get();
	    	departamentoExistente.setName(novoDepartamento.getName());      
	        return departamentoRepository.save(departamentoExistente); 
	    } else {
	        return null; 
	    }
	}
}
