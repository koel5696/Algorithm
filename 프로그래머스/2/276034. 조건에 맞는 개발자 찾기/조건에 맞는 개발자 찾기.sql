-- 코드를 작성해주세요
select distinct d.ID, d.EMAIL, d.FIRST_NAME, d.LAST_NAME
from SKILLCODES s
join DEVELOPERS d
on d.SKILL_CODE & s.CODE > 0
where s.NAME = 'Python' OR s.NAME = 'C#'
order by d.ID ASC