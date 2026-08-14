-- Last updated: 8/14/2026, 8:26:36 PM
-- Write your PostgreSQL query statement below
select
    user_id,
    upper(substring(name from 1 for 1)) ||  lower(substring(name from 2)) as name
from
    Users
order by
    user_id;