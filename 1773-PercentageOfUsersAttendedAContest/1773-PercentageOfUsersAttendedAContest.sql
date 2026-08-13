-- Last updated: 8/13/2026, 11:00:24 AM
-- Write your PostgreSQL query statement below
select
    contest_id,
    round(
        count(*)::numeric * 100 /
        (select count(*) from Users),
        2
    ) as percentage
from Register
group by contest_id
order by percentage desc, contest_id;