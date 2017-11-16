CREATE TABLE tb_usuario(
   id_usuario SERIAL PRIMARY KEY,
   nome VARCHAR(50),
   sobrenome VARCHAR(255)
);
CREATE TABLE tb_endereco(
    id_endereco SERIAL PRIMARY KEY,
    logradouro VARCHAR(100),   
    complemento VARCHAR(50),
    bairro VARCHAR(50),
    numero VARCHAR(10),
    cep VARCHAR(25)
);
CREATE TABLE tb_perfil(
    id_perfil SERIAL PRIMARY KEY,
    nome VARCHAR(255),
    descricao VARCHAR(255)
);