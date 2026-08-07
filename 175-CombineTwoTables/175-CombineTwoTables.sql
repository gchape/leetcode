-- Last updated: 8/7/2026, 11:13:31 AM
-- Write your PostgreSQL query statement below
select firstname, lastName, city, state
from Address a
right outer join Person using(personId);