-- 코드를 입력하세요
SELECT outs.animal_id, outs.name 
from animal_ins as ins 
    inner join animal_outs as outs 
        on ins.animal_id = outs.animal_id 
order by datediff(outs.datetime, ins.datetime) desc 
limit 2