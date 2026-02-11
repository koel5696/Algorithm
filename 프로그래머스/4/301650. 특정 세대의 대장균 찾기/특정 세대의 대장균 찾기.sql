-- 코드를 작성해주세요
select ed3.ID
from ECOLI_DATA ed1
join ECOLI_DATA ed2
join ECOLI_DATA ed3
on ed1.PARENT_ID is null and ed1.ID = ed2.PARENT_ID and ed2.ID = ed3.PARENT_ID
