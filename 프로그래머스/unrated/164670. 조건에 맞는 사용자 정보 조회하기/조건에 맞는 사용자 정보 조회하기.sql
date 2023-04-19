-- 코드를 입력하세요
SELECT u.USER_ID, u.NICKNAME, 
    concat(u.CITY, " ", u.STREET_ADDRESS1, " ", u.STREET_ADDRESS2) as '전체주소', 
    concat(left(u.TLNO, 3), "-", mid(u.TLNO, 4, 4), "-", right(u.TLNO, 4)) as '전화번호'
from USED_GOODS_BOARD as b inner join USED_GOODS_USER as u
    on b.WRITER_ID = u.USER_ID
group by b.WRITER_ID
having count(BOARD_ID) >= 3
order by u.USER_ID desc