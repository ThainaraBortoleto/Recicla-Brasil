create database ReciclaBrasil;
use ReciclaBrasil;

create table operador
(
	id_operador integer unsigned not null,
    nome varchar(200) not null,
    cpf varchar(11) not null,
    data_nascimento timestamp default now(),
    constraint pk_operador primary key (id_operador),
    constraint uk_operador unique key (cpf)
);

create table coletor
(
	id_coletor integer unsigned not null,
    nome varchar(200) not null,
    apelido varchar(100) not null,
    saldo double unsigned,
    data_nascimento timestamp default now(),
    constraint pk_coletor primary key (id_coletor),
    constraint uk_coletor unique key (apelido)
);

create table empresa
(
	id_empresa integer unsigned not null,
    nome_responsavel varchar(200) not null,
    razao_social varchar(200) not null,
    cnpj varchar(18) not null,
    cep varchar(9) not null,
    endereco varchar(255) not null,
    telefone varchar(14) not null,
    email varchar(100) not null,
    hora_marcada varchar(5),
    constraint pk_empresa primary key (id_empresa),
    constraint uk_empresa unique key (cnpj)
);

create table material
(
	id_material integer unsigned not null,
	nome varchar(100) not null,
    quantidade integer unsigned not null,
    limite integer unsigned not null,
    preco double unsigned not null,
    constraint pk_materiais primary key (id_material)
);

create table materiais_coletor
(
	id_material integer unsigned not null,
    id_coletor integer unsigned not null,
    valor_venda double unsigned,
    data_deposito timestamp default now(),
    constraint pk_materiais_coletor primary key (id_material, id_coletor),
    constraint fk_materiais_coleto__coletor foreign key (id_coletor)
		references coletor (id_coletor),
	constraint fk_materiais_coletor__material foreign key (id_material)
		references material (id_material)
);

create table materiais_empresa
(
	id_material integer unsigned not null,
    id_empresa integer unsigned not null,
    valor_compra double unsigned not null,
    data_compra timestamp default now(),
    constraint pk_materiais_empresa primary key (id_material, id_empresa),
    constraint fk_materiais_empresa__material foreign key (id_material)
		references material (id_material),
	constraint fk_materiais_empresa__empresa foreign key (id_empresa)
		references empresa(id_empresa)
);

create table motorista
(
	id_motorista integer unsigned not null,
    id_empresa integer unsigned not null,
    nome varchar(200) not null,
    cpf varchar(11) not null,
    peso_max integer unsigned not null,
    placa varchar(9) not null,
    constraint pk_motorista primary key (id_motorista, id_empresa),
    constraint fk_motorista__empresa foreign key (id_empresa)
		references empresa(id_empresa),
	constraint uk_motorista unique key (cpf)    
);


insert into material values
(1, 'Aluminio', 55, 100, 3.50),
(2, 'Papelao', 70, 100, 3.00),
(3, 'Plastico', 30, 100, 2.50),
(4, 'Vidro', 90, 100, 4.50);

insert into empresa values
(1, 'Teste', 'Razao', 'xxx.xxx.xxx/xx', 'xxxxxxxx', 'Rua Nazare', 'xxxx-xxxx', 'xxxxx@xxx.xxx', '09:00'),
(2, 'Teste2', 'Razao', '111.111.111/11', 'xxxxxxxx', 'Rua Nazare', 'xxxx-xxxx', 'xxxxx@xxx.xxx', '09:00');

insert into materiais_coletor (id_material, id_coletor, valor_venda) values (2, 2, 0);
