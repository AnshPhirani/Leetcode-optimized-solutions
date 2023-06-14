# Write your MySQL query statement below

select T.score, COUNT(DISTINCT S.score) as "rank" from Scores S, Scores T  where S.score >= T.score group by T.id order by T.score desc;