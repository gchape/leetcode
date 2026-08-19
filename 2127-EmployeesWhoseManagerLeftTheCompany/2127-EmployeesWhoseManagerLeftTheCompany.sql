-- Last updated: 8/19/2026, 9:31:22 AM
-- Write your PostgreSQL query statement below
select
    employee_id
from
    Employees
where
    (salary < 30000) and 
    (manager_id not in (select distinct employee_id from Employees))
order by
    employee_id;