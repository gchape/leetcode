-- Last updated: 8/7/2026, 12:57:53 PM
-- Write your PostgreSQL query statement below
select
    product_name,
    year,
    price
from      Sales
left join Product using (product_id);