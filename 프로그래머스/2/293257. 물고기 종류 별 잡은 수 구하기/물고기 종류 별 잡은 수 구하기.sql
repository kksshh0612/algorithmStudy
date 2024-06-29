-- 코드를 작성해주세요

select count(info.id) as fish_count, name.fish_name
from fish_info as info 
    inner join fish_name_info as name 
        on info.fish_type = name.fish_type
group by name.fish_type , name.fish_name
order by fish_count desc