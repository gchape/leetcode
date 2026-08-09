-- Last updated: 8/9/2026, 10:04:31 AM
-- Write your PostgreSQL query statement below
WITH friends AS (
    SELECT requester_id AS id
    FROM RequestAccepted

    UNION ALL

    SELECT accepter_id AS id
    FROM RequestAccepted
),
friend_count AS (
    SELECT
        id,
        COUNT(*) AS num
    FROM friends
    GROUP BY id
)
SELECT id, num
FROM (
    SELECT
        *,
        RANK() OVER (ORDER BY num DESC) AS rnk
    FROM friend_count
) x
WHERE rnk = 1;