package com.algaworks.osworks.api.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.algaworks.osworks.domain.model.Cliente;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

  @PersistenceContext
  private EntityManager em;

  @GetMapping("/clientes")
  public List<Cliente> listar() {
    return em.createQuery("from Cliente", Cliente.class).getResultList();
  }
}