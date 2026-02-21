-- 코드를 입력하세요
with buffer as(
    select PRODUCT_ID, sum(AMOUNT) as total, PRODUCE_DATE
    from FOOD_ORDER
    where PRODUCE_DATE  >= '2022-05-01' and PRODUCE_DATE <     '2022-06-01'
    group by PRODUCT_ID
)
SELECT pro.PRODUCT_ID, pro.PRODUCT_NAME, ord.total * pro.PRICE as TOTAL_SALES
from FOOD_PRODUCT pro
join buffer ord
on pro.PRODUCT_ID = ord.PRODUCT_ID
order by TOTAL_SALES desc, pro.PRODUCT_ID