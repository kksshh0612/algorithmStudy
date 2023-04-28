-- 코드를 입력하세요
SET @hour := -1;
SELECT (@hour := @hour + 1) as HOUR,
    (
        select count(*) 
        from ANIMAL_OUTS 
        where hour(DATETIME) = @hour
    ) as COUNT
from ANIMAL_OUTS
WHERE @hour < 23