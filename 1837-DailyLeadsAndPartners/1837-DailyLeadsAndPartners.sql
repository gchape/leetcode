-- Last updated: 8/14/2026, 8:26:29 PM
-- Write your PostgreSQL query statement below
select
    date_id,
    make_name,
    count(distinct lead_id) as unique_leads,
    count(distinct partner_id) as unique_partners
from
    DailySales
group by
    date_id,
    make_name;