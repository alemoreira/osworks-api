package com.algaworks.osworks.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.osworks.domain.model.Cliente;
import com.algaworks.osworks.domain.repository.ClienteRepository;
import com.algaworks.osworks.domain.service.CadastroClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

  @Autowired
  private CadastroClienteService cadastroClienteService;

  @Autowired
  private ClienteRepository clienteRepository;

  // @GetMapping("/clientes")
  @GetMapping
  public List<Cliente> listar() {
    return clienteRepository.findAll();
  }

  /**
   * @PathVariable faz o binding do {id} com o parâmetro id
   * @param id
   * @return ResponseEntity de Cliente. O ResponseEntity adiciona status retorno,
   *         corpo, etc.
   */
  // @GetMapping("/clientes/{id}")
  @GetMapping("/{id}")
  public ResponseEntity<Cliente> buscar(@PathVariable Long id) {
    Optional<Cliente> optCliente = clienteRepository.findById(id);

    if (optCliente.isPresent()) {
      return ResponseEntity.ok(optCliente.get());
    }
    return ResponseEntity.notFound().build();
  }

  // @PostMapping("/clientes")
  @PostMapping("")
  @ResponseStatus(HttpStatus.CREATED)
  public Cliente adicionar(@RequestBody @Valid Cliente cliente) {
    return cadastroClienteService.salvar(cliente);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody @Valid Cliente cliente) {
    if (!clienteRepository.existsById(id)) {
      return ResponseEntity.notFound().build();
    }

    cliente.setId(id);
    Cliente clienteAtualizado = cadastroClienteService.salvar(cliente);

    return ResponseEntity.ok(clienteAtualizado);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> remover(@PathVariable Long id) {
    if (!clienteRepository.existsById(id)) {
      return ResponseEntity.notFound().build();
    }

    cadastroClienteService.excluir(id);

    return ResponseEntity.noContent().build();
  }

  // Not Restful

  @GetMapping("/buscarPorNome")
  public List<Cliente> buscarPorNome() {
    // return clienteRepository.findByNome("Bil");
    return clienteRepository.findByNomeContaining("Bil");
  }
}