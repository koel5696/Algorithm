-- 코드를 작성해주세요
select ed1.ID, count(ed2.PARENT_ID) as CHILD_COUNT
from ECOLI_DATA ed1
left join ECOLI_DATA ed2
on ed1.ID = ed2.PARENT_ID
Group by ed1.ID