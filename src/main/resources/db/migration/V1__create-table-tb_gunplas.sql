create table tb_gunplas
(
	id bigint not null auto_increment,
	nome varchar(100) not null,
	serie varchar(100) not null,
	unidade varchar(45) not null,
	quantidade varchar(45) not null,
	modelo varchar(2),
	marca varchar(45),
	
	primary key(id)
);