-- Last updated: 8/12/2026, 5:53:11 PM
-- Write your PostgreSQL query statement below
WITH first_orders AS (
    SELECT DISTINCT ON (customer_id)
        order_date,
        customer_pref_delivery_date
    FROM Delivery
    ORDER BY customer_id, order_date
)
SELECT ROUND(
    COUNT(*) FILTER (
        WHERE order_date = customer_pref_delivery_date
    ) * 100.0 / COUNT(*),
    2
) AS immediate_percentage
FROM first_orders;