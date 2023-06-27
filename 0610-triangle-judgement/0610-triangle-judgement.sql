# Write your MySQL query statement below
SELECT *,
IF(x < y+z AND y < x+z AND z < x+y, 'Yes', 'No') 'triangle'
FROM Triangle;