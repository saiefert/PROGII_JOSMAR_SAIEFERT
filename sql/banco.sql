CREATE TABLE tb_usuario(
   id_usuario SERIAL PRIMARY KEY,
   id_usu INT,
   nome VARCHAR(50),
   sobrenome VARCHAR(255)  
);

CREATE TABLE tb_endereco(
    id_endereco SERIAL PRIMARY KEY,
    logradouro VARCHAR(100),   
    complemento VARCHAR(50),
    bairro VARCHAR(50),
    numero VARCHAR(10),
    cep VARCHAR(25),
    id_ender INT
    
);
CREATE TABLE tb_perfil(
    id_perfil SERIAL PRIMARY KEY,
    nome_perfil VARCHAR(255),
    descricao VARCHAR(255)
);

ALTER TABLE tb_usuario
ADD FOREIGN KEY (id_usu)
REFERENCES tb_perfil (id_perfil);

ALTER TABLE tb_endereco
ADD FOREIGN KEY (id_ender)
REFERENCES tb_usuario (id_usuario);