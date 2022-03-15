package com.nisum.eval.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nisum.eval.model.Telefono;

@Repository
public interface ITelefonoRepo extends JpaRepository<Telefono,Integer> {

}
