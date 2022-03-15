package com.nisum.eval.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nisum.eval.model.Persona;

@Repository
public interface IPersonaRepo extends JpaRepository<Persona,Integer> {

}
