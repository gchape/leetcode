-- Last updated: 8/9/2026, 10:04:12 AM
WITH login_next_login AS (
    SELECT
        player_id,
        event_date AS login,
        LEAD(event_date) OVER (
            PARTITION BY player_id
            ORDER BY event_date
        ) AS next_login,
        ROW_NUMBER() OVER (
            PARTITION BY player_id
            ORDER BY event_date
        ) AS rn
    FROM Activity
),
player_count AS (
    SELECT COUNT(DISTINCT player_id) AS count
    FROM Activity
)
SELECT ROUND(
    COUNT(*)::numeric / (SELECT count FROM player_count),
    2
) AS fraction
FROM login_next_login
WHERE rn = 1
  AND login + 1 = next_login;