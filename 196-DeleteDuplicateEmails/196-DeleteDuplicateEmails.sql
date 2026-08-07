-- Last updated: 8/7/2026, 11:13:13 AM
-- Write your PostgreSQL query statement below
delete from Person p1
using Person p2
where p1.id > p2.id and p1.email = p2.email;