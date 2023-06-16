# Write your MySQL query statement below
SELECT DISTINCT L.num "ConsecutiveNums" FROM Logs L
WHERE L.num = (SELECT L1.num FROM Logs L1 WHERE L.id + 1 = L1.id)
AND L.num = (SELECT L2.num FROM Logs L2 WHERE L.id + 2 = L2.id);