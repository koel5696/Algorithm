-- 코드를 입력하세요
with result as (
    SELECT PRODUCT_ID, sum(SALES_AMOUNT) as TOTAL
    from OFFLINE_SALE
    group by PRODUCT_ID
    order by PRODUCT_ID 
)

select pr.PRODUCT_CODE, (r.TOTAL * pr.PRICE) as SALES
from result r
join PRODUCT pr
on r.PRODUCT_ID = pr.PRODUCT_ID
order by SALES desc, pr.PRODUCT_CODE