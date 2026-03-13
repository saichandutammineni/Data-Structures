# Write your MySQL query statement below
SELECT p.firstName, p.lastName, IFNULL(a.city, null) AS city, IFNULL(a.state, null) AS state
FROM Person p
LEFT JOIN Address a ON p.personId=a.personId 