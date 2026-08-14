-- Last updated: 8/14/2026, 8:26:31 PM
-- Write your PostgreSQL query statement below
select
    tweet_id
from
    Tweets
where
    length(content) > 15;