-- 코드를 입력하세요 
SELECT PT_NAME, PT_NO, GEND_CD, AGE, 
Case
    when TLNO is NULL then 'NONE' 
    else TLNO
    end as TLNO
from PATIENT
where AGE <= 12 && GEND_CD = 'W'
order by AGE DESC, PT_NAME ASC;