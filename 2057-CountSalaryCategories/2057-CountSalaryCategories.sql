-- Last updated: 8/9/2026, 10:22:18 AM
-- Write your PostgreSQL query statement below
WITH category_count AS (
    SELECT
        CASE
            WHEN income < 20000 THEN 'Low Salary'
            WHEN income <= 50000 THEN 'Average Salary'
            ELSE 'High Salary'
        END AS category,
        1 AS accounts_count
    FROM Accounts

    UNION ALL
    SELECT 'Low Salary', 0

    UNION ALL
    SELECT 'Average Salary', 0

    UNION ALL
    SELECT 'High Salary', 0
)
SELECT
    category,
    SUM(accounts_count) AS accounts_count
FROM category_count
GROUP BY category;