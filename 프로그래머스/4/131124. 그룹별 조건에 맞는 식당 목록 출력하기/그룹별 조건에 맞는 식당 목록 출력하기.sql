with memberCount as(
    select MEMBER_ID, count(MEMBER_ID) as reviewCount
    from REST_REVIEW
    group by MEMBER_ID
    order by reviewCount desc
), memberCount2 as(
    select r.MEMBER_ID, r.REVIEW_TEXT, m.reviewCount, r.REVIEW_DATE
    from REST_REVIEW r
    join memberCount m
    on r.MEMBER_ID = m.MEMBER_ID
    order by m.MEMBER_ID desc
)
select member.MEMBER_NAME, review.REVIEW_TEXT, 
date_format(review.REVIEW_DATE, '%Y-%m-%d') as REVIEW_DATE
from memberCount2 review
join MEMBER_PROFILE member
on review.MEMBER_ID = member.MEMBER_ID
where review.reviewCount = (
    select max(reviewCount)
    from memberCount2
)
order by REVIEW_DATE, review.REVIEW_TEXT

