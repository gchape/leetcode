-- Last updated: 8/7/2026, 12:58:08 PM
-- Write your PostgreSQL query statement below
select *
from Cinema
where description != 'boring' and id % 2 = 1
order by rating desc;