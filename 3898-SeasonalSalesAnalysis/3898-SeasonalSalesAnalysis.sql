-- Last updated: 8/23/2026, 12:05:18 AM
-- Write your PostgreSQL query statement below
SELECT DISTINCT ON (season)
    CASE
        WHEN EXTRACT(MONTH FROM sale_date) IN (12, 1, 2) THEN 'Winter'
        WHEN EXTRACT(MONTH FROM sale_date) IN (3, 4, 5) THEN 'Spring'
        WHEN EXTRACT(MONTH FROM sale_date) IN (6, 7, 8) THEN 'Summer'
        ELSE 'Fall'
    END AS season,
    category,
    SUM(quantity) AS total_quantity,
    SUM(quantity * price) AS total_revenue
FROM sales
JOIN products USING (product_id)
GROUP BY season, category
ORDER BY
    season,
    total_quantity DESC,
    total_revenue DESC,
    category;