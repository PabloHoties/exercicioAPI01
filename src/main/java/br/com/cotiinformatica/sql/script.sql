#criar um banco de dados
create database exercicioapi01;

#selecionar o banco de dados
use exercicioapi01;

##criar a tabela de produtos
create table produto(
	id_produto		int auto_increment			primary key,
	nome			varchar(150)					not null,
	descricao		varchar(1000)					not null,
	quantidade		int								not null,
	preco			double							not null
);
