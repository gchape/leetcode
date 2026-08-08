-- Last updated: 8/8/2026, 9:12:29 PM
-- Write your PostgreSQL query statement below
select score, dense_rank() over(order by score desc) as rank
from Scores;