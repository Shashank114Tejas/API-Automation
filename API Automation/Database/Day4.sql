Select * from LEARNERS;

Select * from BATCHES

Select * from LEARNERS INNER JOIN BATCHES
on LEARNERS.batch_id= BATCHES.batch_id
where LEARNERS.batch_id in( 'COHORT 1', 'COHORT 3');
--order by lastname desc
--where course like '%Java'

Select relevelId, firstname, LEARNERS.batch_id, course from LEARNERS INNER JOIN BATCHES
on LEARNERS.batch_id= BATCHES.batch_id
where LEARNERS.batch_id in( 'COHORT 1', 'COHORT 3');



Select * from LEARNERS A INNER JOIN BATCHES B
on A.batch_id= B.batch_id
where A.batch_id in( 'COHORT 1', 'COHORT 3')


--Left Joins

Select * from LEARNERS A LEFT JOIN BATCHES B
on A.batch_id= B.batch_id

Select * from BATCHES A LEFT JOIN LEARNERS B
on A.batch_id= B.batch_id

Select * from BATCHES A LEFT OUTER JOIN LEARNERS B
on A.batch_id= B.batch_id

--Right Joins

Select * from LEARNERS A RIGHT JOIN BATCHES B
on A.batch_id= B.batch_id

Select * from LEARNERS A RIGHT OUTER JOIN BATCHES B
on A.batch_id= B.batch_id

--Full Joins

Select * from LEARNERS A Full OUTER JOIN BATCHES B
on A.batch_id= B.batch_id

Select * from LEARNERS order by firstname

Aggregate Functions

Select count(*) from LEARNERS;  
Select count(*) from BATCHES; 

Select sum(exp) from LEARNERS;  

Select sum(FIRSTNAME) from LEARNERS;  --WON'T WORK

Select max(exp) from LEARNERS;

Select max(firstname) from LEARNERS; 

Select min(exp) from LEARNERS; 

Select min(firstname) from LEARNERS; 


Select avg(exp) from LEARNERS; 

Select avg(firstname) from LEARNERS; --WON'T WORK


