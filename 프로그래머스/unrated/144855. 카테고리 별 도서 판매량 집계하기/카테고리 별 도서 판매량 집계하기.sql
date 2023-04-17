-- 코드를 입력하세요
SELECT b.CATEGORY, sum(s.SALES) as TOTAL_SALES
from BOOK as b, BOOK_SALES as s
where b.BOOK_ID = s.BOOK_ID and s.SALES_DATE like '2022-01%'
group by b.CATEGORY
order by b.CATEGORY
