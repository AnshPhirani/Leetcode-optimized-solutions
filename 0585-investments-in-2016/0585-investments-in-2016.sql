# Write your MySQL query statement below

SELECT ROUND(SUM(TIV_2016), 2) 'TIV_2016' FROM Insurance I
WHERE TIV_2015 IN
(SELECT TIV_2015 FROM Insurance GROUP BY TIV_2015 HAVING COUNT(*) > 1)
AND CONCAT(I.lat,",",I.lon) NOT IN 
(SELECT CONCAT(lat,",",lon) FROM Insurance GROUP BY lat, lon HAVING COUNT(*) > 1);