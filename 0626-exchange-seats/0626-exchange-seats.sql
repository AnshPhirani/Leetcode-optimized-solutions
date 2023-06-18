# Write your MySQL query statement below
SELECT
(CASE 
    WHEN MOD(S.id, 2) != 0 AND S.id = (SELECT MAX(s.id) FROM Seat s) THEN S.id
    WHEN MOD(S.id, 2) != 0 THEN S.id+1
    WHEN MOD(S.id, 2) = 0 THEN S.id-1
END) AS 'id', S.student FROM Seat S ORDER BY id ASC;
