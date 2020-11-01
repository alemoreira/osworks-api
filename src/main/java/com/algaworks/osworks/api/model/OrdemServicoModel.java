package com.algaworks.osworks.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.algaworks.osworks.domain.model.StatusOrdemServico;

import lombok.Data;

/**
 * Classe de representação do modelo de Ordem serviço para API via pattern,
 * Representetion Model.
 */

@Data
public class OrdemServicoModel {
  private Long id;
  private String nomeCliente;
  private String descricao;
  private BigDecimal preco;
  private StatusOrdemServico status;
  private OffsetDateTime abertaEm;
  private OffsetDateTime finalizadaEm;
}
