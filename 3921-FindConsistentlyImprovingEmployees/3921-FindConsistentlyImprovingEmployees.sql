-- Last updated: 8/23/2026, 12:05:22 AM
-- Write your PostgreSQL query statement below
WITH ranked AS (
    SELECT
        employee_id,
        rating,
        review_date,
        ROW_NUMBER() OVER (
            PARTITION BY employee_id
            ORDER BY review_date DESC
        ) AS rn,
        LAG(rating) OVER (
            PARTITION BY employee_id
            ORDER BY review_date DESC
        ) AS prev_rating
    FROM performance_reviews
)
SELECT
    e.employee_id,
    e.name,
    MAX(r.rating) - MIN(r.rating) AS improvement_score
FROM ranked r
JOIN employees e USING (employee_id)
WHERE r.rn <= 3
GROUP BY e.employee_id, e.name
HAVING COUNT(*) = 3
   AND COUNT(*) FILTER (
       WHERE r.rn > 1
         AND r.rating < r.prev_rating
   ) = 2
ORDER BY improvement_score DESC, e.name;