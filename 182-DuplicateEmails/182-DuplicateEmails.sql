-- Last updated: 8/7/2026, 11:13:22 AM
-- Write your PostgreSQL query statement below
select
    email as "Email"
from
    Person
group by
    email having count(*) > 1;