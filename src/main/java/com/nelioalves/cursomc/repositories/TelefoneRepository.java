package com.nelioalves.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nelioalves.cursomc.entities.Telefone;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, String>{

}
