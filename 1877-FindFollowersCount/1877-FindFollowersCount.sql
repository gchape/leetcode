-- Last updated: 8/14/2026, 8:26:27 PM
-- Write your PostgreSQL query statement below
select
    user_id,
    count(*) as followers_count
from
    Followers
group by
    user_id
order by
    user_id;