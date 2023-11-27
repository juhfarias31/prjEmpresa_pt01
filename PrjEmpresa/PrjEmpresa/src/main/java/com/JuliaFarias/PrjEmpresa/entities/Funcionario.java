package com.JuliaFarias.PrjEmpresa.entities;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long funcodigo;
		

	private String funname;
		
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate funnascimento;

	private double funsalario;

	public Long getFuncodigo() {
		return funcodigo;
	}

	public void setFuncodigo(Long funcodigo) {
		this.funcodigo = funcodigo;
	}

	public String getFunname() {
		return funname;
	}

	public void setFunname(String funname) {
		this.funname = funname;
	}

	public LocalDate getFunnascimento() {
		return funnascimento;
	}

	public void setFunnascimento(LocalDate funnascimento) {
		this.funnascimento = funnascimento;
	}

	public double getFunsalario() {
		return funsalario;
	}

	public void setFunsalario(double funsalario) {
		this.funsalario = funsalario;
	}
}