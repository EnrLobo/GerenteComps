package br.edu.ifsuldeminas.mch.springbootcrud.model.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Campeonato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotNull
    private LocalDate dataInicio;

    @NotNull
    private LocalDate dataFim;

    @NotBlank
    private String modalidade;
    
    

    public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public LocalDate getDataInicio() {
		return dataInicio;
	}



	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}



	public LocalDate getDataFim() {
		return dataFim;
	}



	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}



	public String getModalidade() {
		return modalidade;
	}



	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}



	public List<Time> getTimes() {
		return times;
	}



	public void setTimes(List<Time> times) {
		this.times = times;
	}



	@OneToMany(mappedBy = "campeonato", cascade = CascadeType.ALL)
    private List<Time> times = new ArrayList<>();
}

