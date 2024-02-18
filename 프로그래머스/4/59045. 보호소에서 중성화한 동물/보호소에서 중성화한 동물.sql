-- 코드를 입력하세요
SELECT outs.animal_id, outs.animal_type, outs.name
from animal_ins as ins 
    inner join animal_outs as outs 
        on ins.animal_id = outs.animal_id 
where ins.sex_upon_intake <> outs.sex_upon_outcome 