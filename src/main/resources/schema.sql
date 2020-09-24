create table example
(
   ID INT PRIMARY KEY AUTO_INCREMENT,
   NAME varchar(255) not null,
   VERSION varchar(10) not null,
   INSERTDATE date
);



create table usuario
(
   ID INT PRIMARY KEY AUTO_INCREMENT,
   NOME VARCHAR(255) NOT NULL,
   CPF  VARCHAR(60) NOT NULL,
   EMAIL VARCHAR(255)
   --DATANASC date NOT NULL



);