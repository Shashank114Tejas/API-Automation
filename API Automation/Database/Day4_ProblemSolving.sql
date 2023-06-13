--Create an Employees Table
CREATE TABLE employees
( employee_number int NOT NULL,
 last_name char(50) NOT NULL,
 first_name char(50) NOT NULL,
 salary int,
 dept_id int,
 CONSTRAINT employees_pk PRIMARY KEY (employee_number)
);


--To see all the tables in SQL Server Database
SELECT table_name, table_schema
FROM information_schema.tables
WHERE table_type = 'BASE TABLE'
ORDER BY table_name ASC;

--Insert into tables

insert into employees values(101,'Soni','Palash',100000,001);  --Shashank
Insert INTO Employees Values(102, 'Keshri','Isha',50000,001);  --ISHA
Insert into employees Values(103,'Akshay','Bhat',60000,001); --Shubham
insert into employees values(104,'S','Sravanthi',50000,002);  --Sravanthi
insert into employees values(105,'Kumar','Shashank',150000,002);  --Palash
insert into employees values(106,'Prathyu','Sha',250000,003); --Prathyusha
insert into employees VALUES(107,'KUMAR','KP',300000,003); --Rakesh
insert into employees values(108,'Singh','Vinita',70000,009); --Vinita
insert into employees(Employee_number,last_name,first_name,salary,dept_id)values(109,'Siddhartha','Parihar',300000,009); --Siddhartha
insert into employees values(110,'Patel','Kiran',450000,004); --Kiran
insert into employees values(121,'Kumar','Suraj',450000,004); --Suraj

Select * from Employees;

--Write a query to print Employee details whose salary is less than 52000
Select * from Employees where salary < 52000
Select count(*) from Employees where salary < 52000

-- first name starts with “S”
Select * from Employees where first_name like 's%';
Select * from Employees where first_name like 'S%';
Select * from Employees where first_name like '%ha';
Select * from Employees where first_name like '%s%';

--Write a query to get employee details receiving the maximum salary from the employees’ table.

Select max(salary) from Employees; -- salary = 450000

Select * from Employees where salary = 450000

Select * from Employees where salary in (Select max(salary) from Employees);  --Subquery
Select * from Employees where salary = (Select max(salary) from Employees);  --Subquery

--Write a query to get employee details receiving the minimum salary from the employees table.

Select min(salary) from Employees; -- salary = 450000

Select * from Employees where salary in (Select min(salary) from Employees);  --Subquery
Select * from Employees where salary = (Select min(salary) from Employees);  --Subquery

--Write a query to get employee details about getting the second highest salary.

Select * from employees where salary=(select max(salary) from Employees where salary !=(select max(salary) from
Employees));

--Create Department table

CREATE TABLE department
( id int not null,
 department_name varchar(40),
 CONSTRAINT department_pk PRIMARY KEY (id)
);

Select * from Department;

insert into department values(1,'Accounts');
insert into department values(2,'Legal');
insert into department values(3,'HR');
insert into department values(4,'Operations');
insert into department values(9,'IT');

--Write a query to print Employee details working in the Legal Department.

select * from Employees E  inner join department D 
on E.dept_id=D.id 
where department_name='legal';

select employee_number, last_name, first_name, salary, E.dept_id, department_name from Employees E  inner join department D 
on E.dept_id=D.id 
where department_name='legal';

select E.employee_number, E.last_name, E.first_name, E.salary, E.dept_id, D.department_name from Employees E  inner join department D 
on E.dept_id=D.id 
where D.department_name='legal';

--Write a query to print the employee details of who is working in the Accounts Department and getting the maximum salary.

Select * from Employees where salary=( Select max(E.salary) from Employees E
inner join Department D
On E.dept_id=D.id
where D.department_name in('Accounts'));

--Write a query to add the projectId column in the department table

Select * from Department;

Alter table Department 
add projectId int;

--Update projectId as 1 for the department having department name as Accounts

Update Department 
set projectId=1 
where department_name='Accounts'

Update Department 
set projectId=3 
where department_name in('Legal','Operations')

Select * from employees

Update employees
set salary = '500000'
where Employee_number = 102;


--Write a query to return the number of employees working in each department.

select count(*),dept_id from employees 
group by dept_id;

--Write a query to print employees' details working in the Accounts Department with a salary greater than 70K.

select * from Employees E  inner join department D 
on E.dept_id=D.id 
where salary > 70000;

--Write a query to print employees' details either working in the Accounts Department or having a salary greater than 70K.

select * from Employees E  inner join department D 
on E.dept_id=D.id 
where department_name='Accounts'  
OR salary > 70000;

--Write a query to print employee details whose salaries are between 70,000 to 150,000

Select * from Employees where Salary between 70000 and 150000;

--Write a query to get full outer join between employees and the Department.

select * from Employees E  full outer join department D 
on E.dept_id=D.id 

--Write a query to print employee details with respect to salary in descending order

select * from Employees order by salary;