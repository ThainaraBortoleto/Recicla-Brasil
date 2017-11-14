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
    hora_marcada varchar(5),
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

create table materiais
(
	id integer unsigned not null,
	nome varchar(100) not null,
    quantidade integer unsigned not null,
    limite integer unsigned not null,
    preco double unsigned not null,
    constraint pk_materiais primary key (id)
);

insert into materiais values
(1, 'Aluminio', 55, 100, 3.50),
(2, 'Papelao', 70, 100, 3.00),
(3, 'Plastico', 30, 100, 2.50),
(4, 'Vidro', 90, 100, 4.50);

insert into empresa values
(1, 'Teste', 'Razao', 'xxx.xxx.xxx/xx', 'xxxxxxxx', 'Rua Nazare', 'xxxx-xxxx', 'xxxxx@xxx.xxx', '09:00'),
(2, 'Teste2', 'Razao', '111.111.111/11', 'xxxxxxxx', 'Rua Nazare', 'xxxx-xxxx', 'xxxxx@xxx.xxx', '09:00');