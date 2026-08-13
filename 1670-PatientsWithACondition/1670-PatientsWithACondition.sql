-- Last updated: 8/13/2026, 11:00:29 AM
-- Write your PostgreSQL query statement below
select
    patient_id,
    patient_name,
    conditions
from Patients
where conditions like 'DIAB1%'
   or conditions like '% DIAB1%';