CREATE TABLE public.Usuario
(
	codUsuario serial primary key,
	login varchar(45),
	senha varchar(45),
	nivelAcesso varchar(45)
);

insert into usuario (login, senha, nivelAcesso) values ('adm', '123', 'administrador');
insert into usuario (login, senha, nivelAcesso) values ('mesario', '123', 'mesario');

CREATE TABLE public.Administrador (
	codAdm serial primary key,
	nome varchar (45),
	cpf varchar (45),
	dataNasc varchar (45),
	tel varchar (45),
	usuario_codUsuario int,
	foreign key (usuario_codUsuario) references Usuario (codUsuario)
);

insert into administrador (nome, cpf, dataNasc, tel, usuario_codUsuario) values ('adm', '123', '10-10-2010', '(11)97070-7070', '1');
insert into administrador (nome, cpf, dataNasc, tel, usuario_codUsuario) values ('mesario', '123', '10-10-2010', '(11)97070-7070', '2');

CREATE TABLE public.Arbitro (
	codArbitro serial primary key,
	nome varchar (45),
	cpf varchar (45),
	dataNasc varchar (45),
	tel varchar (45),
	usuario_codUsuario int,
	foreign key (usuario_codUsuario) references Usuario (codUsuario)
);

CREATE TABLE public.Competicao (
	codCompeticao serial primary key,
	nomeCompeticao varchar (45),
	endereco varchar (45),
	dataCompeticao varchar (45),
	horario varchar (45)
);



CREATE TABLE public.Categoria (
	codCategoria serial primary key,
	descCategoria varchar (45),
	idade varchar (45),
	sexo varchar (45)
);

insert into categoria(descCategoria, idade, sexo) values('Cadete','14','Masculino');
insert into categoria(descCategoria, idade, sexo) values('Cadete','14','Feminino');
insert into categoria(descCategoria, idade, sexo) values('Junior','17','Masculino');
insert into categoria(descCategoria, idade, sexo) values('Junior','17','Feminino');
insert into categoria(descCategoria, idade, sexo) values('Sub 30','30','Masculino');
insert into categoria(descCategoria, idade, sexo) values('Sub 30','30','Feminino');
insert into categoria(descCategoria, idade, sexo) values('Sub 40','40','Masculino');
insert into categoria(descCategoria, idade, sexo) values('Sub 40','40','Feminino');
insert into categoria(descCategoria, idade, sexo) values('Sub 50','50','Masculino');
insert into categoria(descCategoria, idade, sexo) values('Sub 50','50','Feminino');
insert into categoria(descCategoria, idade, sexo) values('Sub 60','60','Masculino');
insert into categoria(descCategoria, idade, sexo) values('Sub 60','60','Feminino');

CREATE TABLE public.Competicao_Categoria (
	categoria_codCategoria int,
	competicao_codCompeticao int,
	primary key (categoria_codCategoria, competicao_codCompeticao),
	foreign key (categoria_codCategoria) references Categoria (codCategoria),
	foreign key (competicao_codCompeticao) references Competicao (codCompeticao)
);

--insert into competicao_categoria (categoria_codCategoria, competicao_codCompeticao) values('1','1');

CREATE TABLE public.Atleta
(
	codAtleta serial primary key,
	nome varchar(45),
	cpf varchar(45),
	dataNasc varchar(45),
	tel varchar(45),
	graduacao varchar(45),
	academia varchar(45),
	notaFinal float,
	usuario_codUsuario int,
	foreign key (usuario_codUsuario) references Usuario (codUsuario)
);

CREATE TABLE public.Fase (
	codFase serial primary key,
	descricao varchar(45)
);

insert into fase(descricao) values('Eliminatórias');
insert into fase(descricao) values('Semifinal');
insert into fase(descricao) values('Final');

CREATE TABLE public.NotaFinal (
	codNotaFinal serial primary key,
	notaFinal float,
	somaApresentacao float,
	somaTecnica float,
	somaNotas float,
	fase_codFase int,
	foreign key (fase_codFase) references Fase (codFase)
);

CREATE TABLE public.Nota (
	codNota serial primary key,
	tecnica float,
	apresentacao float,
	situacaoTecnica varchar (45),
	situacaoApresentacao varchar (45),
	arbitro_codArbitro int,
	notaFinal_codNotaFinal int,
	foreign key (arbitro_codArbitro) references Arbitro (codArbitro),
	foreign key (notaFinal_codNotaFinal) references NotaFinal (codNotaFinal)
);

CREATE TABLE public.Inscricao (
	atleta_codAtleta int,
	competicao_categoria_codCategoria int,
	competicao_categoria_codCompeticao int,
	notaFinal_codNotaFinal int,
	inscricaoAtiva varchar(45),
	primary key (atleta_codAtleta, competicao_categoria_codCategoria, competicao_categoria_codCompeticao),
	foreign key (atleta_codAtleta) references Atleta (codAtleta),
	foreign key (competicao_categoria_codCategoria, competicao_categoria_codCompeticao) references Competicao_Categoria (categoria_codCategoria, competicao_codCompeticao),
	foreign key (notaFinal_codNotaFinal) references NotaFinal (codNotaFinal)
);

update NotaFinal set fase_codFase = '3' where fase_codFase is null;

select * from nota;
select * from notaFinal;
select * from usuario;
select * from atleta;
select * from categoria;
select * from fase;
select * from administrador;
select * from arbitro;
select * from competicao;
select * from Competicao_Categoria;
select * from inscricao;


--Comando para excluir tudo e refazer do zero...
drop schema public cascade;
create schema public;


update inscricao set inscricaoAtiva = null where inscricao.atleta_codAtleta = 1;
update NotaFinal set fase_codFase = null where codNotaFinal = '1';


update notaFinal notaFinal set notaFinal = '0.0', somaApresentacao = '0.0', somaTecnica = '0.0', somaNotas = '0.0' where codNotaFinal = '1';

select tecnica, apresentacao from nota where codNota = '5';

select arbitro.codArbitro, usuario.login, usuario.senha, usuario.nivelAcesso from arbitro, usuario where usuario.login = 'arbitro1' and usuario.codUsuario = arbitro.usuario_codUsuario;

update inscricao set inscricaoAtiva = 'ativa' where inscricao.atleta_codAtleta = 1;

update inscricao set inscricaoAtiva = null where inscricao.atleta_codAtleta = 1;
update NotaFinal set fase_codFase = null where codNotaFinal = '1';

insert into inscricao(atleta_codAtleta, competicao_categoria_codCategoria, competicao_categoria_codCompeticao, notaFinal_codNotaFinal) values('1','5','1','1');

select max(codNotaFinal) from notaFinal;

insert into NotaFinal (notaFinal, somaApresentacao, somaNotas, fase_codFase) values ('8.2', '8.3', '8.0', '1');
insert into Nota (tecnica, apresentacao, situacaoTecnica, situacaoApresentacao, arbitro_codArbitro, notaFinal_codNotaFinal) values ('8.3', '8.3', 'Aprovada', 'Aprovada', '1', '1');

update inscricao set notaFinal_codNotaFinal = '1' where atleta_codAtleta = '1';

select * from notaFinal where codNotaFinal = '1';

update inscricao set inscricaoAtiva = 'ativa' where inscricao.atleta_codAtleta = 1;
update NotaFinal set fase_codFase = '3' where inscricao.atleta_codAtleta = 1; 

select atleta.nome, categoria.descCategoria, fase.descricao
from atleta, competicao, categoria, fase, inscricao, notafinal, competicao_categoria 
where inscricao.inscricaoAtiva is 'ativa' and 
atleta.codAtleta = inscricao.atleta_codAtleta and 
inscricao.notaFinal_codNotaFinal = notafinal.codNotaFinal and 
notafinal.fase_codFase = fase.codFase and 
inscricao.competicao_categoria_codCompeticao = competicao_categoria.competicao_codCompeticao and 
inscricao.competicao_categoria_codCategoria = competicao_categoria.categoria_codCategoria and 
competicao_categoria.competicao_codCompeticao = competicao.codCompeticao and 
competicao_categoria.categoria_codCategoria = categoria.codCategoria;

select atleta.CodAtleta, atleta.nome, competicao.nomeCompeticao, categoria.descCategoria
from atleta, competicao, categoria, inscricao, competicao_categoria
where inscricao.inscricaoAtiva is null and atleta.CodAtleta = inscricao.atleta_codAtleta and 
inscricao.competicao_categoria_codCompeticao = competicao_categoria.competicao_codCompeticao and
inscricao.competicao_categoria_codCategoria = competicao_categoria.categoria_codCategoria and
competicao_categoria.competicao_codCompeticao = competicao.codCompeticao and
competicao_categoria.categoria_codCategoria = categoria.codCategoria;

select atleta.CodAtleta, atleta.nome, competicao.nomeCompeticao, categoria.descCategoria, fase.descricao, notafinal.NotaFinal 
from atleta, competicao, categoria, fase, inscricao, notafinal, competicao_categoria
where atleta.CodAtleta = '1' and atleta.CodAtleta = inscricao.atleta_codAtleta and 
inscricao.notaFinal_codNotaFinal = notafinal.codNotaFinal and
notafinal.fase_codFase = fase.codFase and
inscricao.competicao_categoria_codCompeticao = competicao_categoria.competicao_codCompeticao and
inscricao.competicao_categoria_codCategoria = competicao_categoria.categoria_codCategoria and
competicao_categoria.competicao_codCompeticao = competicao.codCompeticao and
competicao_categoria.categoria_codCategoria = categoria.codCategoria;

select max(codNotaFinal) from notaFinal;

select atleta.CodAtleta, atleta.nome, competicao.nomeCompeticao, categoria.descCategoria, fase.descricao, notafinal.NotaFinal from atleta, competicao, categoria, fase, inscricao, notafinal, competicao_categoria where inscricao.inscricaoAtiva is null and atleta.CodAtleta = inscricao.atleta_codAtleta and inscricao.notaFinal_codNotaFinal = notafinal.codNotaFinal and notafinal.fase_codFase = fase.codFase and inscricao.competicao_categoria_codCompeticao = competicao_categoria.competicao_codCompeticao and inscricao.competicao_categoria_codCategoria = competicao_categoria.categoria_codCategoria and competicao_categoria.competicao_codCompeticao = competicao.codCompeticao and competicao_categoria.categoria_codCategoria = categoria.codCategoria;

select atleta.CodAtleta, atleta.nome, competicao.nomeCompeticao, categoria.descCategoria, fase.descricao, notafinal.NotaFinal from atleta, competicao, categoria, fase, inscricao, notafinal, competicao_categoria where atleta.CodAtleta = inscricao.atleta_codAtleta and inscricao.notaFinal_codNotaFinal = notafinal.codNotaFinal and notafinal.fase_codFase = fase.codFase and inscricao.competicao_categoria_codCompeticao = competicao_categoria.competicao_codCompeticao and inscricao.competicao_categoria_codCategoria = competicao_categoria.categoria_codCategoria and competicao_categoria.competicao_codCompeticao = competicao.codCompeticao and competicao_categoria.categoria_codCategoria = categoria.codCategoria;

select atleta.CodAtleta, atleta.nome, competicao.nome, categoria.descCategoria, fase.descricao, notafinal.NotaFinal from atleta, competicao, categoria, fase, inscricao, notafinal, competicao_categoria where atleta.CodAtleta = '1' and atleta.CodAtleta = inscricao.atleta_codAtleta and inscricao.notaFinal_codNotaFinal = notafinal.codNotaFinal and notafinal.fase_codFase = fase.codFase and inscricao.competicao_categoria_codCompeticao = competicao_categoria.competicao_codCompeticao and inscricao.competicao_categoria_codCategoria = competicao_categoria.categoria_codCategoria and competicao_categoria.competicao_codCompeticao = competicao.codCompeticao and competicao_categoria.categoria_codCategoria = categoria.codCategoria;

select atleta.CodAtleta, atleta.nome, competicao.nome, categoria.descCategoria from atleta, competicao, categoria, inscricao, competicao_categoria where atleta.CodAtleta = '1' and atleta.CodAtleta = inscricao.atleta_codAtleta and inscricao.competicao_categoria_codCompeticao = competicao_categoria.competicao_codCompeticao and inscricao.competicao_categoria_codCategoria = competicao_categoria.categoria_codCategoria and competicao_categoria.competicao_codCompeticao = competicao.codCompeticao and competicao_categoria.categoria_codCategoria = categoria.codCategoria;

select atleta.CodAtleta, competicao.nome, categoria.descCategoria from atleta, competicao, categoria, inscricao, competicao_categoria where atleta.CodAtleta = 1 and atleta.CodAtleta = inscricao.atleta_codAtleta and inscricao.competicao_categoria_codCompeticao = competicao_categoria.competicao_codCompeticao and inscricao.competicao_categoria_codCategoria = competicao_categoria.categoria_codCategoria and competicao_categoria.competicao_codCompeticao = competicao.codCompeticao and competicao_categoria.categoria_codCategoria = categoria.codCategoria;

insert into competicao_categoria(categoria_codCategoria, competicao_codCompeticao) values(2,2);

insert into inscricao(atleta_codAtleta, competicao_categoria_codCategoria, competicao_categoria_codCompeticao) values('1','1','5');

select codCompeticao, nome from competicao order by codCompeticao;

select codCompeticao, nome from competicao order by codCompeticao;

select atleta.CodAtleta, atleta.nome, competicao.nomeCompeticao, categoria.descCategoria, fase.descricao, notafinal.NotaFinal from atleta, competicao, categoria, fase, inscricao, notafinal, competicao_categoria where atleta.CodAtleta = 1 and inscricao.notaFinal_codNotaFinal is null and atleta.CodAtleta = inscricao.atleta_codAtleta and inscricao.notaFinal_codNotaFinal = notafinal.codNotaFinal and notafinal.fase_codFase = fase.codFase and inscricao.competicao_categoria_codCompeticao = competicao_categoria.competicao_codCompeticao and inscricao.competicao_categoria_codCategoria = competicao_categoria.categoria_codCategoria and competicao_categoria.competicao_codCompeticao = competicao.codCompeticao and competicao_categoria.categoria_codCategoria = categoria.codCategoria;

select * from usuario where login = ? and senha = ?;

select arbitro.codArbitro, usuario.login, usuario.senha, usuario.nivelAcesso from arbitro, usuario where usuario.login = 'B' and usuario.senha = '2' and usuario.codUsuario = arbitro.usuario_codUsuario;

insert into usuario (login, senha, nivelAcesso) values ('mesario', '123', 'mesario');
insert into administrador (codAdm, nome, cpf, dataNasc, tel) values ('adm', '123', '10-10-2010', '(11)97070-7070', '2');

insert into nota(tecnica, apresentacao, arbitro_codArbitro) values('5.2','5.3','7');

select * from atleta where codAtleta = '1';

update arbitro SET nome  = 'Jose Maria', cpf = '44455566677', dataNasc = '18/06/1990', tel = '(11) 96520-5410' WHERE codArbitro = '1';

delete from usuario where login = 'alex';

select atleta.CodAtleta atleta.nome competicao.nome categoria.descCategoria fase.descricao notafinal.NotaFinal where 

insert into inscricao (atleta_codAtleta, competicao_categoria_codCategoria, competicao_categoria_codCompeticao) values('1','1','1');

select codCompeticao, nome from competicao order by codCompeticao;

select codCompeticao, nome from competicao order by codCompeticao;

select * from usuario where login = ? and senha = ?;

select arbitro.codArbitro, usuario.login, usuario.senha, usuario.nivelAcesso from arbitro, usuario where usuario.login = 'B' and usuario.senha = '2' and usuario.codUsuario = arbitro.usuario_codUsuario;

insert into usuario (login, senha, nivelAcesso) values ('mesario', '123', 'mesario');
insert into administrador (codAdm, nome, cpf, dataNasc, tel) values ('adm', '123', '10-10-2010', '(11)97070-7070', '2');

insert into nota(tecnica, apresentacao, arbitro_codArbitro) values('5.2','5.3','7');

select * from atleta where codAtleta = '1';

update arbitro SET nome  = 'Jose Maria', cpf = '44455566677', dataNasc = '18/06/1990', tel = '(11) 96520-5410' WHERE codArbitro = '1';

delete from usuario where login = 'alex';
select atleta.CodAtleta, atleta.nome, competicao.nome, categoria.descCategoria, fase.descricao, notafinal.NotaFinal from atleta, competicao, categoria, fase, inscricao, notafinal, competicao_categoria where atleta.CodAtleta = 1 and atleta.CodAtleta = inscricao.atleta_codAtleta and inscricao.notaFinal_codNotaFinal = notafinal.codNotaFinal and notafinal.fase_codFase = fase.codFase and inscricao.competicao_categoria_codCompeticao = competicao_categoria.competicao_codCompeticao and inscricao.competicao_categoria_codCategoria = competicao_categoria.categoria_codCategoria and competicao_categoria.competicao_codCompeticao = competicao.codCompeticao and competicao_categoria.categoria_codCategoria = categoria.codCategoria;
            
select atleta.CodAtleta, atleta.nome, competicao.nome, categoria.descCategoria, fase.descricao from atleta, competicao, categoria, fase, inscricao, notafinal, competicao_categoria where atleta.CodAtleta = ? and atleta.CodAtleta = inscricao.atleta_codAtleta and inscricao.notaFinal_codNotaFinal = notafinal.codNotaFinal and notafinal.fase_codFase = fase.codFase and inscricao.competicao_categoria_codCompeticao = competicao_categoria.competicao_codCompeticao and inscricao.competicao_categoria_codCategoria = competicao_categoria.categoria_codCategoria and competicao_categoria.competicao_codCompeticao = competicao.codCompeticao and competicao_categoria.categoria_codCategoria = categoria.codCategoria;

--Comando para excluir tudo e refazer do zero...
drop schema public cascade;
create schema public;