-- Last updated: 8/7/2026, 12:58:05 PM
-- Write your PostgreSQL query statement below
update Salary
set sex = (
    case
        when sex = 'm'
                then 'f'
                else 'm'
    end
);