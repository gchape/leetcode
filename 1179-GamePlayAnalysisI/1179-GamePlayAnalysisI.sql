-- Last updated: 8/7/2026, 11:12:43 AM
-- Write your PostgreSQL query statement below
select distinct on (player_id) player_id, event_date as "first_login"
from Activity
order by player_id, event_date;