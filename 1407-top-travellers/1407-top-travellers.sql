# Write your MySQL query statement below

SELECT Users.name, IFNULL(SUM(Rides.distance), 0) 'travelled_distance' FROM Users LEFT jOIN Rides 
ON Users.id = Rides.user_id GROUP By Users.id ORDER by travelled_distance desc , Users.name;