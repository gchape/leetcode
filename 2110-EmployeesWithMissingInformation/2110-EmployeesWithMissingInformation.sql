-- Last updated: 8/19/2026, 9:31:24 AM
-- Write your PostgreSQL query statement below
select
    employee_id
from
    Employees
full outer join Salaries using (employee_id)
where
    (name is null) or (salary is null);