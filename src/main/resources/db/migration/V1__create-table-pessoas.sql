create table pessoas (

    id bigint not null auto_increment,
    nome varchar(100) not null,
    idade varchar(3) not null,
    genero varchar(100) not null,
    cpf varchar(11) not null unique,
    logradouro varchar(100) not null,
    bairro varchar(100) not null,
    cep varchar(9) not null,
    numero varchar(20) not null,
    complemento varchar(100),
    cidade varchar(100) not null,
    uf char(2) not null,
    telefone varchar(14),
    email varchar(100) not null unique,

    primary key(id)
);