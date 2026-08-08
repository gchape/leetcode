-- Last updated: 8/8/2026, 11:02:03 PM
-- Write your PostgreSQL query statement below
select Department, Employee, Salary
from (
select
    d.name as Department,
    e.name as Employee,
    e.salary as Salary,
    rank() over (partition by d.name order by salary desc) as rnk
from Department d
inner join Employee e on d.id = e.departmentId
)
where rnk = 1;