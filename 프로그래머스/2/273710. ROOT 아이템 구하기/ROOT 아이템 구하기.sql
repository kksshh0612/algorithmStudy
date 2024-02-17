-- 코드를 작성해주세요
select info.ITEM_ID, info.ITEM_NAME 
from ITEM_INFO as info inner join ITEM_TREE as tree 
    on info.ITEM_ID = tree.ITEM_ID
where tree.PARENT_ITEM_ID is NULL