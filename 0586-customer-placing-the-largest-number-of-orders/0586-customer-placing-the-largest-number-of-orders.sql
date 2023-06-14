
select customer_number from Orders group by customer_number 
having count(order_number) = (select max(order_count) from (select count(order_number) as order_count from Orders group by customer_number) as i);

