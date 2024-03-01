# Write your MySQL query statement below
# Select product_id, new_price as price from Products where change_date <= "2019-08-16" order by change_date desc group by product_id;

select product_id, new_price as price from Products where (product_id, change_date) IN 
(select product_id, max(change_date) from Products where change_date <= "2019-08-16" group by product_id)
UNION
select product_id, 10 as price from Products where product_id Not IN
(select product_id from Products where change_date <= "2019-08-16");
