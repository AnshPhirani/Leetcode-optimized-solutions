# Write your MySQL query statement below
(SELECT u.name 'results' FROM MovieRating m JOIN Users u
ON m.user_id = u.user_id
GROUP BY m.user_id ORDER BY COUNT(*) DESC, u.name LIMIT 1)
UNION ALL
(SELECT m2.title FROM MovieRating m JOIN Movies m2
ON m.movie_id = m2.movie_id WHERE DATE_FORMAT(m.created_at, '%Y-%m') = '2020-02'
GROUP BY m.movie_id ORDER BY AVG(m.rating) DESC, m2.title LIMIT 1);