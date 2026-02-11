-- 코드를 작성해주세요
select ID, case
    when 0.75 < sort 
    then 'LOW'
    when 0.5 < sort 
    then 'MEDIUM'
    when 0.25 < sort 
    then 'HIGH'
    else 'CRITICAL' end as COLONY_NAME
from (
    select ID, percent_rank() OVER (order by SIZE_OF_COLONY
                                  desc) as sort
    from ECOLI_DATA) buffer
order by ID