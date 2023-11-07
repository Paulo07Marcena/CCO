create database AmericanVehicle;
use AmericanVehicle;

create table carros (
id int primary key auto_increment,
ano int,
marca varchar(45),
modelo varchar(45),
preco float
);

select * from carros;
