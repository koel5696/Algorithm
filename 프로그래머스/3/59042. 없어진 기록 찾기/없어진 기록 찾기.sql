-- 코드를 입력하세요
SELECT distinct out1.ANIMAL_ID, out1.NAME
from ANIMAL_OUTS out1
left join ANIMAL_INS in1
on out1.ANIMAL_ID = in1.ANIMAL_ID
where in1.ANIMAL_ID is null
order by out1.ANIMAL_ID