-- Last updated: 8/12/2026, 5:53:42 PM
-- Write your PostgreSQL query statement below
SELECT id,
       CASE
           WHEN id % 2 = 1 AND next_student IS NULL THEN student
           WHEN id % 2 = 1 THEN next_student
           ELSE prev_student
       END AS student
FROM (
    SELECT id,
           student,
           LEAD(student) OVER (ORDER BY id) AS next_student,
           LAG(student)  OVER (ORDER BY id) AS prev_student
    FROM Seat
) s;