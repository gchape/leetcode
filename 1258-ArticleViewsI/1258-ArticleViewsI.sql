-- Last updated: 8/7/2026, 11:22:21 PM
-- Write your PostgreSQL query statement below
select distinct author_id as id
from Views
where author_id = viewer_id
order by id;