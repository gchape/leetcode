-- Last updated: 8/9/2026, 10:04:40 AM
-- Write your PostgreSQL query statement below
with at_least_five as (
    select managerId
    from Employee
    group by managerId having count(*) >= 5
)
select name 
from at_least_five alf
inner join Employee e on alf.managerId = e.id; 