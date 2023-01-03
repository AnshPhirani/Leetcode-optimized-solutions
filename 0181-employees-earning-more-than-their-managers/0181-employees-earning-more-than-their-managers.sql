# Write your MySQL query statement below

# select name from Employee where salary > (select salary from Employee where )

select e1.name as Employee from Employee e1, Employee e2 where e1.managerId = e2.id and e1.salary > e2.salary; 