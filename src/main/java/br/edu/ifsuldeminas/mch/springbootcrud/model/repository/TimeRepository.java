package br.edu.ifsuldeminas.mch.springbootcrud.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsuldeminas.mch.springbootcrud.model.entity.Time;


public interface TimeRepository extends JpaRepository<Time, Long>{


}
