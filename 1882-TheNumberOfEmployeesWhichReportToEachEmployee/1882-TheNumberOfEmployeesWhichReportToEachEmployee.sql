-- Last updated: 8/14/2026, 8:26:25 PM
-- Write your PostgreSQL query statement below
select
    employee_id,
    name,
    count(*) as reports_count,
    round(avg(rprts.age)) as average_age
from
    Employees
inner join (
    select 
        reports_to, 
        age 
    from Employees 
    where reports_to is not null
) as rprts on employee_id = rprts.reports_to
group by
    employee_id, name
order by
    employee_id;