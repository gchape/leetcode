-- Last updated: 8/7/2026, 11:13:12 AM
-- Write your PostgreSQL query statement below
select w1.id
from Weather w1
inner join Weather w2
  on w1.recordDate = w2.recordDate + interval '1 day'
where w1.temperature > w2.temperature;