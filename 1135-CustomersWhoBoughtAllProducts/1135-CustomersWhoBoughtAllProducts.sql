-- Last updated: 8/12/2026, 5:53:31 PM
-- Write your PostgreSQL query statement below
select c.customer_id
from (
    select
        customer_id, 
        count(distinct product_key) as products_bought
    from Customer
    group by customer_id
) c
where c.products_bought = (
    select count(*)
    from Product
);