-- 코드를 입력하세요
SELECT m.member_name as MEMBER_NAME, r.review_text as REVIEW_TEXT, 
    date_format(r.review_date, '%Y-%m-%d') as REVIEW_DATE 
from member_profile as m 
    inner join rest_review as r
        on m.member_id = r.member_id 
where r.member_id = (
    select member_id 
    from rest_review
    group by member_id 
    order by count(*) desc
    limit 1
)
order by REVIEW_DATE, REVIEW_TEXT