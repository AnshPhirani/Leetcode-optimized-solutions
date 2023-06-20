# Write your MySQL query statement below
SELECT machine_id, ROUND(AVG(IF(activity_type = 'end', timestamp, -timestamp))*2, 3) 'processing_time' FROM Activity GROUP BY machine_id; 