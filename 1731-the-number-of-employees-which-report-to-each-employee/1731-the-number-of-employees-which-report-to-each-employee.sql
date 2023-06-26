# Write your MySQL query statement below
SELECT 
reports_to 'employee_id', 
(SELECT name FROM Employees e2 WHERE e2.employee_id = e1.reports_to) 'name', 
COUNT(reports_to) 'reports_count',
ROUND(AVG(age), 0) 'average_age'
FROM Employees e1 WHERE reports_to IS NOT NULL
GROUP BY reports_to ORDER BY 1;