-- Last updated: 8/12/2026, 5:52:54 PM
-- Write your PostgreSQL query statement below
select 
    product_name,
    sum(unit) as unit
from
           Products
inner join Orders using (product_id)
where
    to_char(order_date, 'YYYY-MM') = '2020-02'
group by product_name 
    having sum(unit) >= 100;