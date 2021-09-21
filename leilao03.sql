create database leilao03
use leilao03

create table tb_empresa_leilao (
	id int not null primary key identity(1,1),
	nome varchar(255) not null
)

create table tb_leilao (
	id int not null primary key identity(1,1),
	descricao varchar(255) not null,
	data_leilao datetime not null,
	id_empresa_leilao int not null references tb_empresa_leilao(id)
)

create table tb_tipo_pessoa (
	id int not null primary key identity(1,1),
	nome varchar(255) not null,
	email varchar(255) not null,
	telefone varchar(20) not null,
)

create table tb_veterinario (
	id int not null primary key identity(1,1),
	crmv varchar(255) not null,
	id_tipo_pessoa int not null references tb_tipo_pessoa(id)
)

create table tb_vendedor (
	id int not null primary key identity(1,1),
	ie varchar(255) not null,
	id_tipo_pessoa int not null references tb_tipo_pessoa(id)
)

create table tb_comprador (
	id int not null primary key identity(1,1),
	cpf varchar(255) not null,
	lance numeric(10,2) not null,
	id_tipo_pessoa int not null references tb_tipo_pessoa(id)
)

create table tb_animal (
	id int not null primary key identity(1,1),
	descricao varchar(255) not null,
	registro varchar(255) not null,
	preco numeric(10,2) not null default(0)
)

create table tb_atendimento (
	id int not null primary key identity(1,1),
	descricao varchar(255) not null,
	data_atendimento datetime not null,
	id_veterinario int not null references tb_veterinario(id),
	id_animal int not null references tb_animal(id)
)

create table tb_animal_leilao (
	id int not null primary key identity(1,1),
	id_animal int not null references tb_animal(id),
	id_leilao int not null references tb_leilao(id)
)

create table tb_venda (
	id int not null primary key identity(1,1),
	descricao varchar(255) not null,
	id_vendedor int not null references tb_vendedor(id),
	id_comprador int not null references tb_comprador(id)
)

create table tb_animal_venda (
	id int not null primary key identity(1,1),
	id_venda int not null references tb_venda(id),
	id_animal int not null references tb_animal(id)
)

create table tb_pagamento(
	id int not null primary key identity(1,1),
	descricao varchar(50) not null,
	id_venda int not null references tb_venda(id)
)

insert into tb_empresa_leilao (nome) values ('Boi gordo leilões')

insert into tb_leilao (descricao, data_leilao, id_empresa_leilao) values ('Leilão Nelore', '2021-09-22', 1)

insert into tb_animal (descricao, registro, preco) values ('Boi macho preto', 'xxx326', 7000.00)

insert into tb_animal_leilao (id_animal, id_leilao) values (1, 1)

insert into tb_tipo_pessoa (nome, email, telefone) values ('Carlos', 'carlosgamer@gmail.com', '67994220311')
insert into tb_tipo_pessoa (nome, email, telefone) values ('Marcos', 'marcoslover@gmail.com', '67992220311')
insert into tb_tipo_pessoa (nome, email, telefone) values ('Misael', 'misael123@gmail.com', '67994120311')

insert into tb_comprador (cpf, lance, id_tipo_pessoa) values ('00122364152', 7100.00, 1)

insert into tb_vendedor (ie, id_tipo_pessoa) values ('465124681', 2)

insert into tb_veterinario (crmv, id_tipo_pessoa) values ('00122364152', 3)

insert into tb_atendimento(descricao, data_atendimento, id_veterinario, id_animal) values ('Vacinação 2021-2', '2021-08-10', 1, 1)

insert into tb_venda (descricao, id_vendedor, id_comprador) values ('venda de boi', 1, 1)

insert into tb_animal_venda (id_animal, id_venda) values (1, 1)

insert into tb_pagamento(descricao, id_venda) values ('CARTAO', 1)

select * from tb_empresa_leilao
select * from tb_leilao
select * from tb_animal_leilao
select * from tb_atendimento
select * from tb_veterinario
select * from tb_tipo_pessoa
select * from tb_vendedor
select * from tb_comprador
select * from tb_animal
select * from tb_venda
select * from tb_animal_venda

