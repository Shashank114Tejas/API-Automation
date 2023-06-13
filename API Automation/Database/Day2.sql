CREATE DATABASE relevel;   -- Creating a database

create table LEARNERS   --Create a table
(
relevelId int,
firstname varchar(20),   
lastname varchar(20),
batch_id varchar(15),
dateofjoining date,
exp int
);


Select * from LEARNERS;

Select exp, firstname, lastname from LEARNERS;


INSERT INTO LEARNERS (relevelId, firstname, lastname, batch_id, dateofjoining, exp)   --Insert data into tables
VALUES (311, 'Siddharth', 'Singh', 'COHORT 3' , '01-02-2022', 2);
INSERT INTO LEARNERS (relevelId, firstname, lastname, batch_id, dateofjoining, exp)   
VALUES (213, 'Sravanthi', 'S', 'COHORT 2' , '01-01-2022', 3);
INSERT INTO LEARNERS (relevelId, firstname, lastname, batch_id, dateofjoining, exp)   
VALUES (214, 'Yogesh', 'Khemnar', 'COHORT 2' , '11-01-2022', 2);


Select * from LEARNERS where exp >= 2 and lastname ='Kumar';


Select DISTINCT batch_id from LEARNERS;