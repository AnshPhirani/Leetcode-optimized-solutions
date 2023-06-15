

SELECT S.name from SalesPerson S
where S.sales_id NOT IN
(Select O.sales_id from Orders O
 where O.com_id IN 
(SELECT C.com_id FROM Company C WHERE C.name = "RED" ));