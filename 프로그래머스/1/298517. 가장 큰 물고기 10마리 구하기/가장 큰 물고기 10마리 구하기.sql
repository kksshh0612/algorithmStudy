-- 코드를 작성해주세요

select id, length
from fish_info 
where length is not null and length > 10
order by length desc, id asc
limit 10
