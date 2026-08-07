-- Last updated: 8/7/2026, 11:13:21 AM
-- Write your PostgreSQL query statement below
select c.name as "Customers"
from Customers c
where not exists (
    select 1
    from Orders o
    where c.id = o.customerId
);