-- Last updated: 8/14/2026, 8:26:15 PM
-- Write your PostgreSQL query statement below
select
    employee_id,
    case
        when (employee_id % 2 = 0) or (name like 'M%') then 0
                                                        else salary
    end as bonus
from
    Employees
order by
    employee_id;