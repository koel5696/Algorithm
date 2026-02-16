-- 코드를 입력하세요
with result as(
    SELECT NAME
    from ANIMAL_INS
    group by NAME

)
select count(NAME) as count
from result