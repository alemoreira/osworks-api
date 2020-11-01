package com.algaworks.osworks.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
@Entity
public class OrdemServico {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Valid
  @NotNull
  @ManyToOne
  // @JoinColumn(name = "cliente_id")
  private Cliente cliente;

  @JsonProperty(access = Access.READ_ONLY)
  @Enumerated(EnumType.STRING)
  private StatusOrdemServico status;

  @NotBlank
  private String descricao;

  @NotNull
  private BigDecimal preco;

  @JsonProperty(access = Access.READ_ONLY)
  private LocalDateTime abertaEm;

  @JsonProperty(access = Access.READ_ONLY)
  private LocalDateTime finalizadaEm;
}
