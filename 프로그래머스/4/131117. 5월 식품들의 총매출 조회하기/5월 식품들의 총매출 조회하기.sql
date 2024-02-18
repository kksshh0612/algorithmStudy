-- 코드를 입력하세요
SELECT p.product_id as PRODUCT_ID, p.product_name as PRODUCT_NAME, 
    sum(p.price * o.amount) as TOTAL_SALES 
from food_product as p
    inner join food_order as o 
        on p.PRODUCT_ID = o.PRODUCT_ID 
where date_format(o.produce_date, '%Y-%m') = '2022-05'
group by PRODUCT_ID
order by TOTAL_SALES desc, PRODUCT_ID