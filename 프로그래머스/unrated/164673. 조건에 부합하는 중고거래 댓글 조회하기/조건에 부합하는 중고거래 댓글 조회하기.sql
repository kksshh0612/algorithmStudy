-- 코드를 입력하세요
SELECT b.TITLE, b.BOARD_ID, r.REPLY_ID, r.WRITER_ID, r.CONTENTS, DATE_FORMAT(r.CREATED_DATE, "%Y-%m-%d") 
as CREATED_DATE
from USED_GOODS_BOARD as b
join USED_GOODS_REPLY as r 
on b.BOARD_ID = r.BOARD_ID
# where r.CREATED_DATE like "2022-10%"
where b.CREATED_DATE like "2022-10%"
order by r.CREATED_DATE asc, b.TITLE asc