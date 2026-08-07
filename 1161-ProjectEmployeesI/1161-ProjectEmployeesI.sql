-- Last updated: 8/7/2026, 11:22:35 PM
-- Write your PostgreSQL query statement below
select project_id, round(avg(experience_years), 2) as average_years
from Project
inner join Employee using (employee_id)
group by project_id;