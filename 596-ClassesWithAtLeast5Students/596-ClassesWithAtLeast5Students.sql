-- Last updated: 8/7/2026, 12:58:17 PM
-- Write your PostgreSQL query statement below
select
    class
from
    Courses
group by class having count(*) >= 5;