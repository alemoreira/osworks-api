package com.algaworks.osworks.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.osworks.domain.model.Foo;

/**
 * FooController
 * Controlador de exemplo para demonstrar como expor uma interface.
 */
@RestController
public class FooController {

  @GetMapping("/foos")
  public List<Foo> listar() {
    var foo1 = new Foo();
    foo1.setId(1L);
    foo1.setNome("Alessandro");
    foo1.setEmail("ale@email.com");
    foo1.setTelefone("859992147041");

    var foo2 = new Foo();
    foo2.setId(2L);
    foo2.setNome("Leila");
    foo2.setEmail("leila@email.com");
    foo2.setTelefone("85999998888");
    
    return Arrays.asList(foo1, foo2);
  }
}