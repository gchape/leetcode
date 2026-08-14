-- Last updated: 8/14/2026, 8:26:18 PM
-- Write your PostgreSQL query statement below
select
    product_id
from
    Products
where
    low_fats::boolean and recyclable::boolean;