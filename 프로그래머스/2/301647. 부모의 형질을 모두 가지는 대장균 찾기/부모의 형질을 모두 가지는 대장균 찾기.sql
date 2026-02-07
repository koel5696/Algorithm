-- 코드를 작성해주세요
select ed1.ID, ed1.GENOTYPE, ed2.GENOTYPE as PARENT_GENOTYPE
from ECOLI_DATA ed1
join ECOLI_DATA ed2
on ed1.PARENT_ID = ed2.ID
where ed1.GENOTYPE & ed2.GENOTYPE >= ed2.GENOTYPE
order by ed1.ID ASC