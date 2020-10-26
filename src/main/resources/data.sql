-- SEED

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