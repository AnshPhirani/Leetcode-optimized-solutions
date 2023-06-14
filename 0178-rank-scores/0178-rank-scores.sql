# Write your MySQL query statement below

SELECT s1.score, (SELECT COUNT(DISTINCT s2.score) FROM Scores s2 WHERE s2.score >= s1.score) AS 'rank' FROM Scores s1
ORDER BY s1.score DESC;