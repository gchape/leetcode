-- Last updated: 8/19/2026, 9:31:17 AM
-- Write your PostgreSQL query statement below
select
    teacher_id,
    count(distinct subject_id) as cnt
from
    Teacher
group by
    teacher_id;