-- Last updated: 8/7/2026, 12:58:29 PM
-- Write your PostgreSQL query statement below
select
    name, bonus
from            Employee
left outer join Bonus   using(empId)
where bonus < 1000 or bonus is null;