-- Last updated: 8/12/2026, 5:53:28 PM
-- Write your PostgreSQL query statement below
WITH first_year AS (
    SELECT product_id, MIN(year) AS first_year
    FROM Sales
    GROUP BY product_id
)
SELECT s.product_id,
       s.year AS first_year,
       s.quantity,
       s.price
FROM Sales s
JOIN first_year f
  ON s.product_id = f.product_id
 AND s.year = f.first_year;