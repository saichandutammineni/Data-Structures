# Write your MySQL query statement below
SELECT min(salary) as SecondHighestSalary FROM (select distinct salary from Employee order by salary DESC limit 1 offset 1) AS temp