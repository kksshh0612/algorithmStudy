-- 코드를 입력하세요
SELECT year(sale.SALES_DATE) as YEAR, month(sale.SALES_DATE) as MONTH, 
    user.GENDER, count(distinct user.USER_ID) as USERS
from USER_INFO as user inner join ONLINE_SALE as sale on user.USER_ID = sale.USER_ID
where user.GENDER is not NULL
group by year(sale.SALES_DATE), month(sale.SALES_DATE), user.GENDER
order by year(sale.SALES_DATE), month(sale.SALES_DATE), user.GENDER
