select ugu.USER_ID, ugu.NICKNAME, sum(ugb.PRICE) as TOTAL_SALES
from USED_GOODS_BOARD as ugb inner join USED_GOODS_USER as ugu
where ugb.WRITER_ID = ugu.USER_ID and ugb.status = "DONE"
group by ugb.WRITER_ID
having sum(ugb.PRICE) >= 700000 
order by sum(ugb.PRICE)