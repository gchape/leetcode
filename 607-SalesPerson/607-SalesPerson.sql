-- Last updated: 8/7/2026, 12:58:18 PM
-- Write your PostgreSQL query statement below
select s.name
from SalesPerson s
where not exists (
    select 1
    from Orders o
    inner join Company c using (com_id)
    where c.name = 'RED' and s.sales_id = o.sales_id
);