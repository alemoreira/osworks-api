package com.algaworks.osworks.api.exceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@JsonInclude(Include.NON_NULL)
@Data
public class Problema {
  private Integer status;
  private LocalDateTime dataHora;
  private String titulo;
  private List<Campo> campos;

  @Data
  public static class Campo {
    private String nome;
    private String mensagem;

    public Campo(String nome, String mensagem) {
      this.nome = nome;
      this.mensagem = mensagem;
    }

  }
}
