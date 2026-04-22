-- Write your query below
-- select name from customers where id not in (select customer_id from orders);
select c.name from customers c left join orders o on c.id = o.customer_id where o.id is null;