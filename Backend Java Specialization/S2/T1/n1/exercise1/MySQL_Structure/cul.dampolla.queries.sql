-- Lists a customer's total invoices in a given period.


-- List the different models of glasses that an employee has sold during a year.
SELECT DISTINCT e.name AS employee_name, g.id AS glassmodel_id
FROM glasses g
JOIN sales s ON s.glass_id = g.idglasses
JOIN employees e ON e.idemployees = s.seller_id
ORDER BY employee_name, glassmodel_id;


-- List the different suppliers who have supplied glasses sold successfully by the optician.
SELECT s.name
FROM suppliers s
JOIN glasses g ON g.supplier_id = s.idsuppliers
JOIN sales s ON s.glass_id = g.idglasses
ORDER BY s.name;