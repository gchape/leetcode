-- Last updated: 8/12/2026, 5:52:49 PM
-- Write your PostgreSQL query statement below
select
    unique_id, name
from
            Employees
left join   EmployeeUNI using (id);