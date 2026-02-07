-- 코드를 작성해주세요
select COUNT(CASE 
             WHEN fmi.FISH_NAME in('BASS', 'SNAPPER')
             THEN 1 END) AS FISH_COUNT
from FISH_INFO fi
join FISH_NAME_INFO fmi
on fi.FISH_TYPE = fmi.FISH_TYPE