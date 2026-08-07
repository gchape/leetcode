-- Last updated: 8/7/2026, 11:13:25 AM
-- Write your PostgreSQL query statement below
select e.name as "Employee"
from Employee e
inner join Employee m on (e.managerId = m.id)
where e.salary > m.salary;