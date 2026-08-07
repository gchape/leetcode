-- Last updated: 8/7/2026, 11:22:28 PM
SELECT
    p.product_id,
    p.product_name
FROM Product p
WHERE EXISTS (
    SELECT 1
    FROM Sales s
    WHERE s.product_id = p.product_id
)
AND NOT EXISTS (
    SELECT 1
    FROM Sales s
    WHERE s.product_id = p.product_id
      AND (
          s.sale_date < DATE '2019-01-01'
          OR s.sale_date > DATE '2019-03-31'
      )
);