-- 코드를 작성해주세요
select d.DEPT_ID, d.DEPT_NAME_EN, round(avg(e.sal), 0) as AVG_SAL
from HR_DEPARTMENT as d 
    inner join HR_EMPLOYEES as e
        on d.DEPT_ID = e.DEPT_ID
group by e.DEPT_ID
order by AVG_SAL desc

