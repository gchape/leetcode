-- Last updated: 8/14/2026, 8:26:20 PM
-- Write your PostgreSQL query statement below
select
    event_day as day,
    emp_id,
    sum(out_time) - sum(in_time) as total_time
from
    Employees
group by
    event_day, emp_id;