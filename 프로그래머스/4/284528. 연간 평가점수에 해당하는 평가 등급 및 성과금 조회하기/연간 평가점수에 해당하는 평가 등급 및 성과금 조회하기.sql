-- 코드를 작성해주세요
select e.EMP_NO, e.EMP_NAME,
    case
        when (sum(g.SCORE) / 2) >= 96 
        then 'S'
        when (sum(g.SCORE) / 2) >= 90 and (sum(g.SCORE) / 2) < 96
        then 'A'
        when (sum(g.SCORE) / 2) >= 80 and (sum(g.SCORE) / 2) < 90
        then 'B'
        else 'C'
    end as GRADE,
    case
        when (sum(g.SCORE) / 2) >= 96 
        then e.SAL * 0.2
        when (sum(g.SCORE) / 2) >= 90 and (sum(g.SCORE) / 2) < 96
        then e.SAL * 0.15
        when (sum(g.SCORE) / 2) >= 80 and (sum(g.SCORE) / 2) < 90
        then e.SAL * 0.1
        else 0
    end as BONUS
from HR_DEPARTMENT as d
    inner join HR_EMPLOYEES as e on d.DEPT_ID = e.DEPT_ID
    inner join HR_GRADE as g on e.EMP_NO = g.EMP_NO
group by e.EMP_NO
order by e.EMP_NO
