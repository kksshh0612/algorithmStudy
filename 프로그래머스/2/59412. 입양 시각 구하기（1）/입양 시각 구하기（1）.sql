-- 코드를 입력하세요
SELECT hour(DATETIME) as hour, count(*) as count
from ANIMAL_OUTS 
where hour(DATETIME) >= 9 and hour(DATETIME) < 20
group by hour(DATETIME)
order by hour(DATETIME)