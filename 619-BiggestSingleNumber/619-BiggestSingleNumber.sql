-- Last updated: 8/7/2026, 12:58:13 PM
-- Write your PostgreSQL query statement below
SELECT (
    SELECT num
    FROM MyNumbers
    GROUP BY num
    HAVING COUNT(*) = 1
    ORDER BY num DESC
    LIMIT 1
) AS num;