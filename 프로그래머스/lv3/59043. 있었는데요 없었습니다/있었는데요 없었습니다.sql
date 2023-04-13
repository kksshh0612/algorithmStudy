-- 코드를 입력하세요
# SELECT ANIMAL_INS.ANIMAL_ID, ANIMAL_OUTS.NAME
# from ANIMAL_INS, ANIMAL_OUTS 
# where ANIMAL_INS.ANIMAL_ID = ANIMAL_OUTS.ANIMAL_ID and ANIMAL_INS.DATETIME > ANIMAL_OUTS.DATETIME
# order by ANIMAL_INS.DATETIME
SELECT ANIMAL_INS.ANIMAL_ID, ANIMAL_OUTS.NAME
from ANIMAL_INS inner join ANIMAL_OUTS on ANIMAL_INS.ANIMAL_ID = ANIMAL_OUTS.ANIMAL_ID
where ANIMAL_INS.DATETIME > ANIMAL_OUTS.DATETIME
order by ANIMAL_INS.DATETIME