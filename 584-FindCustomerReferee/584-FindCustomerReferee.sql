-- Last updated: 8/7/2026, 12:58:27 PM
-- Write your PostgreSQL query statement below
select name
from Customer
where referee_id != 2 or referee_id is null;