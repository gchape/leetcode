-- Last updated: 8/13/2026, 11:00:25 AM
-- Write your PostgreSQL query statement below
select
    name,
    balance
from (
    select
        account,
        sum(amount) as balance
    from Transactions
    group by account
    having sum(amount) > 10000
) as balances
inner join Users using (account);