package br.edu.ifsuldeminas.mch.springbootcrud.model.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

@Entity
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String cidade;

    @Past
    private LocalDate fundadoEm;

    @Min(1)
    private int numeroDeJogadores;
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCidade() {
		return cidade;
	}



	public void setCidade(String cidade) {
		this.cidade = cidade;
	}



	public LocalDate getFundadoEm() {
		return fundadoEm;
	}



	public void setFundadoEm(LocalDate fundadoEm) {
		this.fundadoEm = fundadoEm;
	}



	public int getNumeroDeJogadores() {
		return numeroDeJogadores;
	}



	public void setNumeroDeJogadores(int numeroDeJogadores) {
		this.numeroDeJogadores = numeroDeJogadores;
	}



	public Campeonato getCampeonato() {
		return campeonato;
	}



	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}



	@ManyToOne
    @JoinColumn(name = "campeonato_id")
    private Campeonato campeonato;
}
