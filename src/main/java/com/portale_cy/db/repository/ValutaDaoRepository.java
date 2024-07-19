package com.portale_cy.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.portale_cy.db.model.Valuta;

@Repository
public interface ValutaDaoRepository extends CrudRepository<Valuta, Long> {
}