create database ReciclaBrasil;
use ReciclaBrasil;

create table coletor
(
	id integer unsigned not null,
    nome varchar(200) not null,
    apelido varchar(100) not null,
    data_nascimento timestamp default now(),
    constraint pk_coletor primary key (id),
    constraint uk_coletor unique key (apelido)
);

create table operador
(
	id integer unsigned not null,
    nome varchar(200) not null,
    cpf varchar(11) not null,
    data_nascimento timestamp default now(),
    constraint pk_operador primary key (id),
    constraint uk_operador unique key (cpf)
);

create table empresa
(
	id integer unsigned not null,
    nome_responsavel varchar(200) not null,
    razao_social varchar(200) not null,
    cnpj varchar(18) not null,
    cep varchar(9) not null,
    endereco varchar(255) not null,
    telefone varchar(14) not null,
    email varchar(100) not null,
    constraint pk_empresa primary key (id),
    constraint uk_empresa unique key (cnpj)
);

create table motorista
(
	id integer unsigned not null,
    id_empresa integer unsigned not null,
    nome varchar(200) not null,
    cpf varchar(11) not null,
    peso_max integer unsigned not null,
    placa varchar(9) not null,
    constraint pk_motorista primary key (id, id_empresa),
    constraint fk_motorista__empresa foreign key (id_empresa)
		references empresa(id),
	constraint uk_motorista unique key (cpf)    
);