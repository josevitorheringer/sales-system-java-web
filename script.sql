CREATE SCHEMA `comercioeletronico` DEFAULT CHARACTER SET utf8mb4;
USE `comercioeletronico` ;

CREATE TABLE `produto` (
  `produto_id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(30)DEFAULT NULL,
  `custo` DOUBLE DEFAULT NULL,
  `quantidade` DOUBLE DEFAULT NULL,
  PRIMARY KEY (`produto_id`));
  
  CREATE TABLE `cliente` (
  `cliente_id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(30) DEFAULT NULL,
  `endereco`  VARCHAR(30) DEFAULT NULL,
  `cpf` VARCHAR(30) NOT NULL,
  `login` VARCHAR(30) DEFAULT NULL UNIQUE,
  `senha`VARCHAR(30) DEFAULT NULL,
  PRIMARY KEY (`cliente_id`));
  
  CREATE TABLE `pedido` (
  `pedido_id` INT NOT NULL AUTO_INCREMENT,
  `cliente_id` INT NOT NULL,
  `produto_id` INT NOT NULL,
  `data` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`pedido_id`),
  FOREIGN KEY(cliente_id) references cliente(cliente_id),
  FOREIGN KEY(produto_id) references produto(produto_id));