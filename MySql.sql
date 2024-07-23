create database pizzeria;
use pizzeria;

create table T_ingredientes(
Nombre varchar (20) primary key,
Precio float);

insert into T_ingredientes values 
('queso','25'),
('peperoni','25');
select nombre from t_ingredientes;


create table T_refrescos(
Id int auto_increment primary key not null,
Marca varchar (25),
Tamaño varchar (20),
Precio float);
select * from t_refrescos;

create table T_empleados(
Id int auto_increment primary key not null,
Nombre varchar (20),
Apellidos varchar (30),
Puesto varchar (15),
Salario float);

insert into T_empleados values 
(0,'a','a','Gerente','2000'),
(0,'b','b','Empleado','2000');
select * from T_empleados;
Select Id,Puesto from T_empleados;

create table T_venta(
Id int auto_increment primary key not null,
Precio float);

create table T_pizzas(
Id int auto_increment primary key not null,
Tamaño varchar (20),
Ingrediente_uno varchar (20),
Ingrediente_dos varchar (20),
Orilla varchar (20),
Precio float,
index(Ingrediente_uno),
index(Ingrediente_dos),
foreign key(Ingrediente_uno) references T_ingredientes(Nombre),
foreign key(Ingrediente_dos) references T_ingredientes(Nombre)
on update restrict on delete restrict);

create table T_ventas_pizzas(
Id int auto_increment primary key not null,
Id_venta int,
Id_pizza int,
cantidad int,
Importe float,
index(Id_venta),
index(Id_pizza),
foreign key(Id_venta) references T_venta(Id),
foreign key(Id_pizza) references T_pizzas(Id)
on update restrict on delete restrict);

create table T_ventas_refrescos(
Id int auto_increment primary key not null,
Id_venta int,
Id_refresco int,
cantidad int,
Importe float,
index(Id_venta),
index(Id_refresco),
foreign key(Id_venta) references T_venta(Id),
foreign key(Id_refresco) references T_refrescos(Id)
on update restrict on delete restrict);

select * from t_ventas_pizzas;
select * from t_ventas_refrescos;
select * from t_venta;