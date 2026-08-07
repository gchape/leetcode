-- Last updated: 8/7/2026, 12:58:21 PM
-- Write your PostgreSQL query statement below
select 
    name, population, area
from
    World
where
    area >= 3000000 or
    population >= 25000000;