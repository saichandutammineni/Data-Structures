# Write your MySQL query statement below
SELECT max(salary) as SecondHighestSalary FROM Employee where salary<(select max(salary) FROM Employee)