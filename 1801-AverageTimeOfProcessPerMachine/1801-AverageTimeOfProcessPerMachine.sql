-- Last updated: 8/13/2026, 10:35:43 AM
select
    machine_id,
    round(
        (
            sum(
                case
                    when activity_type = 'end' then timestamp
                    else -timestamp
                end
            ) / count(distinct process_id)
        )::numeric,
        3
    ) as processing_time
from Activity
group by machine_id;