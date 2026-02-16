-- 코드를 입력하세요
with NEW_JULY as(
    select FLAVOR, sum(TOTAL_ORDER) as total
    from JULY
    group by FLAVOR
)

SELECT fh.FLAVOR
from FIRST_HALF fh
join NEW_JULY july
on fh.FLAVOR = july.FLAVOR
order by fh.TOTAL_ORDER + july.total desc
limit 3