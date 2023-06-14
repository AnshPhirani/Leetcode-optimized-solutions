
select customer_number from Orders group by customer_number 
having count(order_number) = (select count(order_number) from Orders group by customer_number order by count(order_number) desc limit 1);

# select customer_number from Orders group by customer_number order by count(order_number) desc limit 1;
