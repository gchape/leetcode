-- Last updated: 8/23/2026, 12:05:17 AM
-- Write your PostgreSQL query statement below
SELECT
    p.user_id,
    COUNT(*) AS prompt_count,
    t.avg_tokens
FROM prompts p
JOIN (
    SELECT
        user_id,
        ROUND(AVG(tokens), 2) AS avg_tokens
    FROM prompts
    GROUP BY user_id
) t USING (user_id)
GROUP BY
    p.user_id,
    t.avg_tokens
HAVING
    COUNT(*) >= 3
    AND COUNT(*) FILTER (
        WHERE tokens > avg_tokens
    ) >= 1
ORDER BY
    avg_tokens DESC,
    user_id;