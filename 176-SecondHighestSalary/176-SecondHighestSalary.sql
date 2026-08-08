-- Last updated: 8/8/2026, 11:02:15 PM
-- Write your PostgreSQL query statement below
WITH salary_dense_rank AS (
    SELECT
        salary,
        DENSE_RANK() OVER (ORDER BY salary DESC) AS rnk
    FROM Employee
)
SELECT (
    SELECT salary
    FROM salary_dense_rank
    WHERE rnk = 2
    LIMIT 1
) AS SecondHighestSalary;