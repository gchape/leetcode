-- Last updated: 8/12/2026, 5:52:46 PM
-- Write your PostgreSQL query statement below
SELECT
    stock_name,
    SUM(price) FILTER (WHERE operation = 'Sell')
    - SUM(price) FILTER (WHERE operation = 'Buy') AS capital_gain_loss
FROM Stocks
GROUP BY stock_name;