-- SEED
DROP TABLE IF EXISTS ordem_servico;
DROP TABLE IF EXISTS clientes;
 
CREATE TABLE clientes (
  id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  nome VARCHAR(60) NOT NULL,
  email VARCHAR(250) NOT NULL,
  telefone VARCHAR(20) DEFAULT NULL
);
 
INSERT INTO clientes (nome, email, telefone) VALUES
  ('daniel', 'dan@mail.com', '85998745621'),
  ('Bill', 'bill@mail.com', '859965474125');

CREATE TABLE ordem_servico (
  id bigint auto_increment PRIMARY KEY not null,
  cliente_id bigint not null,
  descricao text not null,
  preco decimal(10,2) not null,
  status varchar(20) not null,
  aberta_em datetime not null,
  finalizada_em datetime
);

ALTER TABLE ordem_servico ADD CONSTRAINT fk_ordem_servico_cliente FOREIGN KEY (cliente_id) REFERENCES clientes (id);
