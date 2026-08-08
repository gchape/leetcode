-- Last updated: 8/8/2026, 11:02:13 PM
CREATE OR REPLACE FUNCTION NthHighestSalary(N INT) RETURNS TABLE (Salary INT) AS $$
BEGIN
  RETURN QUERY (
    SELECT (
        SELECT ranked.salary
        FROM (
            SELECT e.salary, DENSE_RANK() OVER (ORDER BY e.salary DESC) AS rnk
            FROM Employee e
        ) ranked
        WHERE ranked.rnk = N
        LIMIT 1
    )
  );
END;
$$ LANGUAGE plpgsql;