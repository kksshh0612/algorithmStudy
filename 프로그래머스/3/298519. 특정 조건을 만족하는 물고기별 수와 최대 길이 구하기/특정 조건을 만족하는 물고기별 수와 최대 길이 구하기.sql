-- 코드를 작성해주세요
select count(*) as fish_count, max(ifnull(LENGTH, 10)) as MAX_LENGTH, FISH_TYPE
from FISH_INFO 
group by FISH_TYPE
having avg(ifnull(LENGTH, 10)) >= 33
order by FISH_TYPE

    