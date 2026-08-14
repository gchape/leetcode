-- Last updated: 8/14/2026, 8:26:16 PM
-- Write your PostgreSQL query statement below
SELECT
    employee_id,
    COALESCE(
        MAX(department_id) FILTER (WHERE primary_flag = 'Y'),
        MAX(department_id)
    ) AS department_id
FROM Employee
GROUP BY employee_id;