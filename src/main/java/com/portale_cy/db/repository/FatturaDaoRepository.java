package com.portale_cy.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.portale_cy.db.model.Fattura;

@Repository
public interface FatturaDaoRepository extends CrudRepository<Fattura, Long> {
}