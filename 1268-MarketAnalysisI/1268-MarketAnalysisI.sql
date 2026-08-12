-- Last updated: 8/12/2026, 5:53:13 PM
-- Write your PostgreSQL query statement below
select
    u.user_id as buyer_id,
    u.join_date,
    count(o.order_id) filter (
        where date_part('year', o.order_date) = 2019
    ) as orders_in_2019
from Users u
left join Orders o
    on o.buyer_id = u.user_id
where date_part('year', u.join_date) < 2020
group by u.user_id, u.join_date;