# Write your MySQL query statement below
# select Salary SecondHighestSalary from Employee order by Salary desc limit 1,1 
select 
(select distinct(Salary) from Employee order by Salary desc limit 1,1)
as SecondHighestSalary

select 
ifnull((select distinct(Salary) from Employee order by Salary desc limit 1,1),null)
as SecondHighestSalary