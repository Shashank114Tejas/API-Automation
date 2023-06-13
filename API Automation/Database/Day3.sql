create table BATCHES   --Create a table
(
batch_id varchar(15),
course varchar(25)
);

INSERT INTO BATCHES (batch_id, course)
VALUES ('COHORT 1', 'Selenium');
INSERT INTO BATCHES (batch_id, course)
VALUES ('COHORT 2', 'Selenium and Java');
INSERT INTO BATCHES (batch_id, course)
VALUES ('COHORT 3', 'Selenium and API');
INSERT INTO BATCHES (batch_id, course)
VALUES ('COHORT 4', 'Angular');
INSERT INTO BATCHES (batch_id, course)
VALUES ('COHORT 5', 'ReactJS');


Select * from BATCHES where batch_id='COHORT 3';

Select batch_id from LEARNERS
UNION
Select batch_id from BATCHES
ORDER BY batch_id;

Select batch_id from LEARNERS
UNION ALL
Select batch_id from BATCHES
ORDER BY batch_id desc;

Select * from LEARNERS 

select firstname, lastname, exp from learners order by exp ;

select firstname, lastname, exp from learners order by exp, firstname ;


Select * from LEARNERS group by batch_id;  --Won't work

Select batch_id from LEARNERS group by batch_id; --Won't work

Select firstname,lastname, batch_id from LEARNERS group by batch_id,firstname,lastname; -- work

Select firstname,lastname, batch_id from LEARNERS 
group by batch_id,firstname,lastname
having lastname like 'Si%';

Select * from LEARNERS where firstname like 'S%'

Select * from LEARNERS where firstname like '%Sh%'

Select * from LEARNERS where lastname like '%mar'

Select * from LEARNERS where lastname in ('S', 'Kumar', 'Patel')

Select * from LEARNERS where exp in (1,2,3,4) 

Select * from LEARNERS where exp BETWEEN 1 AND 4;


Select * from LEARNERS where exp >= 2 or lastname ='Kumar';  


INSERT INTO LEARNERS (relevelId, firstname, lastname, batch_id, dateofjoining, exp)  -- first way to insert 
VALUES (313, 'Suniti Kumari', 'Sahu', 'COHORT 3' , '11-01-2022', 2);

INSERT INTO LEARNERS 
VALUES (315, 'KUmar', 'Gaurav', 'COHORT 3' , '11-03-2022', 3);  -- Second way to insert 

update LEARNERS
set batch_id='COHORT 3',firstname='Suniti', exp =4
where relevelId= 313;

Delete from LEARNERS
where firstname='kumar'

Select count(*) from LEARNERS;  --Aggregate Functions

Select sum(exp) from LEARNERS;  --Aggregate Functions