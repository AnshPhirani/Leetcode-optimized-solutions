# Write your MySQL query statement below

SELECT C.customer_id FROM Customer C group by C.customer_id having count(distinct C.product_key) = (select count(P.product_key) from Product P);