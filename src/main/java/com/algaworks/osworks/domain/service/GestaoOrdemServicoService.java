package com.algaworks.osworks.domain.service;

import java.time.LocalDateTime;

import com.algaworks.osworks.domain.model.OrdemServico;
import com.algaworks.osworks.domain.model.StatusOrdemServico;
import com.algaworks.osworks.domain.repository.OrdemServicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestaoOrdemServicoService {
  @Autowired
  OrdemServicoRepository ordemServicoRepository;

  public OrdemServico criar(OrdemServico ordemServico) {
    ordemServico.setStatus(StatusOrdemServico.ABERTA);
    ordemServico.setAbertaEm(LocalDateTime.now());

    return ordemServicoRepository.save(ordemServico);
  }
}
