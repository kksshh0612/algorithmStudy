-- 코드를 작성해주세요
select sum(g.SCORE) as score, e.EMP_NO, e.EMP_NAME, e.POSITION, e.EMAIL
from HR_DEPARTMENT as d
    inner join HR_EMPLOYEES as e
        on d.DEPT_ID = e.DEPT_ID
    inner join HR_GRADE as g
        on e.EMP_NO = g.EMP_NO
group by g.EMP_NO
order by score desc
limit 1;

