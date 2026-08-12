-- Last updated: 8/12/2026, 5:52:51 PM
-- Write your PostgreSQL query statement below
(select
    name as results
from
          Users
left join MovieRating
            using (user_id)
left join Movies
            using (movie_id)
group by name
order by count(*) desc, name asc
limit 1)

union all

(select
    title
from
          Movies
left join MovieRating
            using (movie_id)
where to_char(created_at, 'YYYY-MM') = '2020-02' 
group by title
order by avg(rating) desc, title asc
limit 1);