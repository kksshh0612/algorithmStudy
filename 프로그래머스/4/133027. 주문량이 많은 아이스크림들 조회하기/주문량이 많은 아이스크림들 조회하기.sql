-- 코드를 입력하세요
SELECT f.FLAVOR 
from FIRST_HALF as f inner join (select SHIPMENT_ID, FLAVOR, sum(TOTAL_ORDER) as total from JULY 
    group by FLAVOR)  as j 
    on f.SHIPMENT_ID = j.SHIPMENT_ID
order by (f.TOTAL_ORDER + j.total) desc 
limit 3

