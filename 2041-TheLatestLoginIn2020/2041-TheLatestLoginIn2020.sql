-- Last updated: 8/14/2026, 8:26:08 PM
-- Write your PostgreSQL query statement below
select distinct on (user_id)
    user_id, 
    time_stamp as last_stamp
from
    Logins
where
    date_part('year', time_stamp) = 2020
order by
    user_id, time_stamp desc;