-- Last updated: 8/12/2026, 5:53:10 PM
-- Write your PostgreSQL query statement below
select
    to_char(trans_date, 'YYYY-MM') as month,
    country,
    count(*) as trans_count,
    count(*) filter (where state = 'approved') as approved_count,
    sum(amount) as trans_total_amount,
    coalesce(sum(amount) filter (where state = 'approved'), 0) as approved_total_amount
from Transactions
group by to_char(trans_date, 'YYYY-MM'), country;