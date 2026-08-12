-- Last updated: 8/12/2026, 5:52:43 PM
-- Write your PostgreSQL query statement below
select
    sell_date,
    count(distinct product) as num_sold,
    string_agg(distinct product, ',' order by product) as products
from
    Activities
group by
    sell_date;