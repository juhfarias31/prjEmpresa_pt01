package com.JuliaFarias.PrjEmpresa.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.JuliaFarias.PrjEmpresa.entities.Funcionario;
import com.JuliaFarias.PrjEmpresa.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
	private final FuncionarioRepository funcionarioRepository;
	
	@Autowired
	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public Funcionario saveFuncionario(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}
	
	public Funcionario getFuncionarioById(Long id) {
		return funcionarioRepository.findById(id).orElse(null);
	}
	
	public Funcionario getFuncionarioById(long id) {
		return funcionarioRepository.findById(id).orElse(null);
	}
	
	public List<Funcionario> getAllFuncionario(){
		return funcionarioRepository.findAll();
	}
	
	public void deletFuncioario(Long id) {
		funcionarioRepository.deleteById(id);
	}
	
	public Funcionario updateFuncionario(Long id, Funcionario novoFuncionario) {
		Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(id);
		
	    if (funcionarioOptional.isPresent()) {
	        Funcionario funcionarioExistente = funcionarioOptional.get();
	        funcionarioExistente.setFunname(novoFuncionario.getFunname());
	        funcionarioExistente.setFuncodigo(novoFuncionario.getFuncodigo());    
	        funcionarioExistente.setFunnascimento(novoFuncionario.getFunnascimento());  
	        funcionarioExistente.setFunsalario(novoFuncionario.getFunsalario());  
	        return funcionarioRepository.save(funcionarioExistente); 
	    } else {
	        return null; 
	    }
	}
}
