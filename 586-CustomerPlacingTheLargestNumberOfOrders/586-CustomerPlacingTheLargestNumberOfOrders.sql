-- Last updated: 8/7/2026, 12:58:25 PM
-- Write your PostgreSQL query statement below
SELECT customer_number
FROM Orders
GROUP BY customer_number
ORDER BY COUNT(*) DESC
LIMIT 1;