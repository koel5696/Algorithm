-- 코드를 작성해주세요
select distinct de.ID, de.EMAIL, de.FIRST_NAME, de.LAST_NAME
from DEVELOPERS de
join SKILLCODES sk
on de.SKILL_CODE & sk.CODE
where CATEGORY = 'Front End'
order by de.ID