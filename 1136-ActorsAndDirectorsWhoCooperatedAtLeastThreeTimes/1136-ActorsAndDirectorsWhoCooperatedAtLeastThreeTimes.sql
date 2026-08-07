-- Last updated: 8/7/2026, 12:57:55 PM
-- Write your PostgreSQL query statement below
select
    actor_id,
    director_id
from
    ActorDirector
group by (actor_id, director_id) having count(*) >= 3;