package com.algaworks.osworks.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity @Data
@Table(name = "clientes")
public class Cliente {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @NotBlank
  @Size(max = 60)
  private String nome;

  @Email
  @Size(max = 255)
  private String email;

  @NotBlank
  @Size(max = 20)
  private String telefone;
}
