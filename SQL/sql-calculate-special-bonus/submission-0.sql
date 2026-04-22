-- Write your query below
-- select name from customers where id not in (select customer_id from orders);
-- select c.name from customers c left join orders o on c.id = o.customer_id where o.id is null;

select
    employee_id,
    case
        when employee_id % 2 = 1 and
name not like 'M%' then salary
        else 0
    end as bonus
from employees
order by employee_id ASC;