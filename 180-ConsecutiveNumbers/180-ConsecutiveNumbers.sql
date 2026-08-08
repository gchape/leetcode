-- Last updated: 8/8/2026, 11:02:08 PM
-- Write your PostgreSQL query statement below
select distinct num as ConsecutiveNums
from (
    select num,
       lag(num) over(order by id) as prev_num,
       lead(num) over(order by id) as next_num
    from Logs
) t
where num = prev_num and num = next_num;