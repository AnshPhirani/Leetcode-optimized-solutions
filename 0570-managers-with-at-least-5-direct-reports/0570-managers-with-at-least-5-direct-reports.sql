# Write your MySQL query statement below
SELECT name FROM Employee WHERE id In (SELECT managerId FROM Employee GROUP BY managerId HAVING COUNT(*) >= 5);