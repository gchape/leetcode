-- Last updated: 8/7/2026, 12:58:14 PM
-- Write your PostgreSQL query statement below
select
    x,
    y,
    z,
    case
        when x + y > z
         and x + z > y
         and y + z > x
        then 'Yes'
        else 'No'
    end as triangle
from Triangle;