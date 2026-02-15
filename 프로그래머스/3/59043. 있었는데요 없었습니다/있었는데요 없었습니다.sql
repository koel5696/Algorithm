-- 코드를 입력하세요
SELECT in1.ANIMAL_ID, out1.NAME
from ANIMAL_INS in1
join ANIMAL_OUTS out1
on in1.ANIMAL_ID = out1.ANIMAL_ID
where in1.DATETIME > out1.DATETIME
order by in1.DATETIME