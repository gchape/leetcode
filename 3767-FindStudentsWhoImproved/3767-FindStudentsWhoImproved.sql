-- Last updated: 8/19/2026, 9:31:12 AM
-- Write your PostgreSQL query statement below
SELECT DISTINCT
    student_id,
    subject,
    first_score,
    latest_score
FROM (
    SELECT
        student_id,
        subject,
        FIRST_VALUE(score) OVER (
            PARTITION BY student_id, subject
            ORDER BY exam_date
        ) AS first_score,
        LAST_VALUE(score) OVER (
            PARTITION BY student_id, subject
            ORDER BY exam_date
            ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING
        ) AS latest_score
    FROM Scores
) s
WHERE latest_score > first_score
ORDER BY student_id, subject;