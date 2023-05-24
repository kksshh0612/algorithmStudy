-- 코드를 입력하세요
SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH, "%Y-%m-%d") as DATE_OF_BIRTH
from MEMBER_PROFILE 
where TLNO is not NULL 
    and GENDER = 'W' 
    and month(DATE_OF_BIRTH) = 3
order by MEMBER_ID