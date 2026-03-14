# Write your MySQL query statement below
SELECT e.name as Employee from Employee e where salary>(SELECT salary From Employee where id=e.managerId) 