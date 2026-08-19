-- Last updated: 8/19/2026, 9:31:00 AM
-- Write your PostgreSQL query statement below
SELECT
    product_id,
    product_name,
    description
FROM products
WHERE description ~ '(^|[^A-Za-z0-9])SN[0-9]{4}-[0-9]{4}([^A-Za-z0-9]|$)'
ORDER BY product_id;