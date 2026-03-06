-- 코드를 입력하세요
SELECT MCDP_CD as '진료과코드', APNT_YMD as '5월예약건수'
from(
    select count(APNT_YMD) as APNT_YMD, MCDP_CD
    from APPOINTMENT
    where APNT_YMD >= '2022-05-01' and APNT_YMD <='2022-05-31'
    group by MCDP_CD
) t
order by APNT_YMD, MCDP_CD