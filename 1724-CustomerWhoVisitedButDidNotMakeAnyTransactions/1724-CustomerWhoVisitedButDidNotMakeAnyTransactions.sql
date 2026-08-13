-- Last updated: 8/13/2026, 11:00:28 AM
-- Write your PostgreSQL query statement below
select 
    customer_id,
    count(*) as count_no_trans
from        Visits
left join   Transactions using (visit_id)
where
    transaction_id is null
group by
    customer_id;