# Write your MySQL query statement below

SELECT user_id,
ROUND(IFNULL(
(SELECT COUNT(*) FROM Confirmations WHERE user_id = S.user_id AND action = 'confirmed')/
(SELECT COUNT(*) FROM Confirmations WHERE user_id = S.user_id), 0), 2) as 'confirmation_rate'
FROM Signups S;