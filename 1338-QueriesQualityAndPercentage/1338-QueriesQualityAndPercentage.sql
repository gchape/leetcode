-- Last updated: 8/12/2026, 5:53:05 PM
-- Write your PostgreSQL query statement below
select
    query_name,
    round(
        avg(
            rating::numeric / position
        )
    , 2) as quality,
    round(
        count(*) filter (where rating < 3)::numeric * 100 / count(*)
    , 2) as poor_query_percentage
from Queries
group by query_name;