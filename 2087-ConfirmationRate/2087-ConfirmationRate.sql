-- Last updated: 8/19/2026, 9:31:27 AM
-- Write your PostgreSQL query statement below
select
    user_id,
    round(
        count(*) filter (where action = 'confirmed')::numeric / 
        count(*)
    , 2) as confirmation_rate
from
    Signups
left join Confirmations using (user_id)
group by user_id;