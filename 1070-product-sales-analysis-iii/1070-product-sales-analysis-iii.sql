# Write your MySQL query statement below
WITH FirstYear AS (
    SELECT 
    product_id,
    MIN(year) 'year'
    FROM Sales GROUP BY product_id
)


SELECT f.product_id, f.year 'first_year', s.quantity, s.price FROM FirstYear f JOIN Sales s 
ON f.product_id = s.product_id AND f.year = s.year;