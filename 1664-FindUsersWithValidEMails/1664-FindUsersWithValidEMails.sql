-- Last updated: 8/12/2026, 5:52:41 PM
-- Write your PostgreSQL query statement below
select
    *
from
    Users
where
    mail ~ '^[A-Za-z][A-Za-z0-9_.-]*@leetcode\.com$';