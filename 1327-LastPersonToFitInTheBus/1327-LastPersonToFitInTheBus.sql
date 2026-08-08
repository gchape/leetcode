-- Last updated: 8/8/2026, 11:01:24 PM
-- Write your PostgreSQL query statement below
select person_name
from (
    select
        turn,
        person_name,
        weight,
        sum(weight) over(order by turn) as total_weight
    from Queue
)
where total_weight <= 1000
order by total_weight desc
limit 1;