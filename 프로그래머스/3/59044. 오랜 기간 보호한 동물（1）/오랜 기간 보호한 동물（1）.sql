-- 코드를 입력하세요
SELECT in1.NAME, in1.DATETIME
from ANIMAL_INS in1
left join ANIMAL_OUTS out1
on in1.ANIMAL_ID = out1.ANIMAL_ID
where out1.ANIMAL_TYPE is null
order by in1.DATETIME
limit 3