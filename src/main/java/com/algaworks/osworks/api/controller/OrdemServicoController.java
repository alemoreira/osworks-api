package com.algaworks.osworks.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import com.algaworks.osworks.api.model.OrdemServicoModel;
import com.algaworks.osworks.domain.exception.NegocioException;
import com.algaworks.osworks.domain.model.Cliente;
import com.algaworks.osworks.domain.model.OrdemServico;
import com.algaworks.osworks.domain.repository.ClienteRepository;
import com.algaworks.osworks.domain.repository.OrdemServicoRepository;
import com.algaworks.osworks.domain.service.GestaoOrdemServicoService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicoController {

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private GestaoOrdemServicoService gestaoOrdemServicoService;

  @Autowired
  private OrdemServicoRepository ordemServicoRepository;

  @Autowired
  private ClienteRepository clienteRepository;

  @GetMapping
  public List<OrdemServicoModel> listar() {
    return toCollectionModel(ordemServicoRepository.findAll());
  }

  /**
   * Padrão Representation Model uso do ModelMapper para criar a
   * representação(negôcio de transitar objeto via Json) com base no modelo(banco
   * de dados).
   * 
   * @param id
   * @return
   */
  @GetMapping("/{id}")
  public ResponseEntity<OrdemServicoModel> buscar(@PathVariable Long id) {
    Optional<OrdemServico> ordemServico = ordemServicoRepository.findById(id);

    if (ordemServico.isPresent()) {
      OrdemServicoModel ordemServicoModel = this.toModel(ordemServico.get());
      // return ResponseEntity.ok(ordemServico.get());
      return ResponseEntity.ok(ordemServicoModel);
    }

    return ResponseEntity.notFound().build();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public OrdemServico criar(@RequestBody @Valid OrdemServico ordemServico) {
    Cliente cliente = clienteRepository.findById(ordemServico.getCliente().getId())
        .orElseThrow(() -> new NegocioException("Cliente não encontrado."));

    ordemServico.setCliente(cliente);
    return gestaoOrdemServicoService.criar(ordemServico);
  }

  private OrdemServicoModel toModel(OrdemServico ordemServico) {
    return modelMapper.map(ordemServico, OrdemServicoModel.class);
  }

  private List<OrdemServicoModel> toCollectionModel(List<OrdemServico> ordensServico) {
    return ordensServico.stream().map(ordemServico -> toModel(ordemServico)).collect(Collectors.toList());
  }
}
