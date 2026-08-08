-- Last updated: 8/8/2026, 11:01:22 PM
SELECT visited_on, amount, average_amount
FROM (
    SELECT
        t.visited_on,
        SUM(t.day_total) OVER (ORDER BY t.visited_on ROWS BETWEEN 6 PRECEDING AND CURRENT ROW) AS amount,
        ROUND(AVG(t.day_total) OVER (ORDER BY t.visited_on ROWS BETWEEN 6 PRECEDING AND CURRENT ROW), 2) AS average_amount,
        ROW_NUMBER() OVER (ORDER BY t.visited_on) AS rnk
    FROM (
        SELECT visited_on, SUM(amount) AS day_total
        FROM Customer
        GROUP BY visited_on
    ) t
) ranked
WHERE rnk > 6
ORDER BY visited_on;