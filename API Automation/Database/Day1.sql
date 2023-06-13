CREATE DATABASE relevel;


create table Employee
(
empId int,
firstname varchar(20),
lastname varchar(20),
dept_id varchar(15),
 dateofjoining date,
 exp int
);


Select * from Employee;



INSERT INTO Employee (empId, firstname, lastname, dept_id, dateofjoining, exp)
VALUES (111, 'Kumar', 'Gaurav', '101' , '01-01-2010', 13);
