package com.JuliaFarias.PrjEmpresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.JuliaFarias.PrjEmpresa.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

}