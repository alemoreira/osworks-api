package com.algaworks.osworks.domain.service;

import java.util.Optional;

import com.algaworks.osworks.domain.exception.NegocioException;
import com.algaworks.osworks.domain.model.Cliente;
import com.algaworks.osworks.domain.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroClienteService {
  @Autowired
  private ClienteRepository clienteRepository;

  /**
   * Criar um novo ou atualizar existente.
   * 
   * @param cliente
   * @return
   */
  public Cliente salvar(Cliente cliente) {
    Optional<Cliente> optClienteExistente = clienteRepository.findByEmail(cliente.getEmail());
    if (optClienteExistente.isPresent() && !optClienteExistente.get().equals(cliente)) {
      throw new NegocioException("Já existe um cliente cadastrado com este e-mail.");
    }
    return clienteRepository.save(cliente);
  }

  public void excluir(Long id) {
    clienteRepository.deleteById(id);
  }
}
