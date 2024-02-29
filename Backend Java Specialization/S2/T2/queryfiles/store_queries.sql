-- List the name of all the products in the product table.
SELECT name
FROM product;

-- List the names and prices of all the products in the product table.
SELECT name, price
FROM product;

-- List all columns of the product table.
SELECT *
FROM product;

-- List the name of the products, the price in euros, and the price in US dollars (USD).
SELECT name, price AS price_ind_euros, price * 1.09 AS price_in_dollars
FROM product;

-- List the name of the products, the price in euros, and the price in US dollars (USD). Use the following aliases: product name, euros, dollars.
SELECT name AS "product name", price AS euros, price * 1.09 AS dollars
FROM product;

-- List the names and prices of all products in the product table, converting the names to uppercase.
SELECT UPPER(name) AS name, price
FROM product;

-- List the names and prices of all products in the product table, converting the names to lowercase.
SELECT LOWER(name) AS name, price
FROM product;

-- List the name of all manufacturers in one column, and in another column capitalize the first two characters.
SELECT name, UPPER(SUBSTRING(name, 1, 2)) AS capped_initials
FROM manufacturer;

-- List the names and prices of all products in the product table, rounding the price value.
SELECT name, ROUND(price) AS rounded_price
FROM product;

-- Lists the names and prices of all products in the product table, truncating the price value.
SELECT name, TRUNCATE(price, 0) AS truncated_price
FROM product;

-- List the code of the manufacturers that have products in the product table.
SELECT m.code
FROM manufacturer m
JOIN product p ON m.code = p.manufacturer_code;

-- List the code of the manufacturers that have products in the product table, eliminating duplicates.
SELECT DISTINCT m.code
FROM manufacturer m
JOIN product p ON m.code = p.manufacturer_code;

-- List manufacturer names in ascending order.
SELECT name
FROM manufacturer
ORDER BY name ASC;

-- List manufacturer names in descending order.
SELECT name
FROM manufacturer
ORDER BY name DESC;

-- Lists product names sorted first by name in ascending order and second by price in descending order.
SELECT name, price
FROM product
ORDER BY name ASC, price DESC;

-- Returns a list with the first 5 rows of the manufacturer table.
SELECT *
FROM manufacturer LIMIT 5;

-- Returns a list with 2 rows starting from the fourth row of the manufacturer table.
SELECT *
FROM manufacturer LIMIT 2 OFFSET 3;

-- List the cheapest product name and price. (Use only the ORDER BY and LIMIT clauses).
SELECT name, price
FROM product
ORDER BY price LIMIT 1;

-- List the name and price of the most expensive product. (Use only the ORDER BY and LIMIT clauses).
SELECT name, price
FROM product
ORDER BY price DESC LIMIT 1;

-- List the name of all products from the manufacturer whose manufacturer code is equal to 2.
SELECT p.name
FROM product p
JOIN manufacturer m ON p.manufacturer_code = m.code
WHERE m.code = 2;

-- Returns a list with the product name, price, and manufacturer name of all products in the database.
SELECT p.name, p.price, m.name AS manufacturer_name
FROM product p
JOIN manufacturer m ON p.manufacturer_code = m.code;

-- Returns a list with the product name, price, and manufacturer name of all products in the database. Sort the result by manufacturer name, in alphabetical order.
SELECT p.name, p.price, m.name AS manufacturer_name
FROM product p
JOIN manufacturer m ON p.manufacturer_code = m.code
ORDER BY manufacturer_name;

-- Returns a list with the product code, product name, manufacturer code, and manufacturer name of all products in the database.
SELECT p.code AS product_code, p.name AS product_name, p.manufacturer_code AS manufacturer_code, m.name AS manufacturer_name
FROM product p
JOIN manufacturer m ON p.manufacturer_code = m.code;

-- Returns the name of the product, its price and the name of its manufacturer, of the cheapest product.
SELECT p.name, p.price, m.name AS manufacturer_name
FROM product p
JOIN manufacturer m ON p.manufacturer_code = m.code
ORDER BY p.price LIMIT 1;

-- Returns the name of the product, its price and the name of its manufacturer, of the most expensive product.
SELECT p.name, p.price, m.name AS manufacturer_name
FROM product p
JOIN manufacturer m ON p.manufacturer_code = m.code
ORDER BY p.price DESC LIMIT 1;

-- Returns a list of all products from manufacturer Lenovo.
SELECT *
FROM product
WHERE manufacturer_code = (SELECT code FROM manufacturer WHERE name = 'Lenovo');

-- Returns a list of all products from manufacturer Crucial that have a price greater than €200.
SELECT *
FROM product
WHERE manufacturer_code = (SELECT code FROM manufacturer WHERE name = 'Crucial')
AND price > 200;

-- Returns a list with all products from manufacturers Asus, Hewlett-Packard and Seagate. Without using the IN operator.
SELECT p.*
FROM product p
JOIN manufacturer m ON p.manufacturer_code = m.code
WHERE m.name = 'Asus' OR m.name = 'Hewlett-Packard' OR m.name = 'Seagate';

-- Returns a list with all products from manufacturers Asus, Hewlett-Packard and Seagate. Using the IN operator.
SELECT p.*
FROM product p
JOIN manufacturer m ON p.manufacturer_code = m.code
WHERE m.name IN ('Asus', 'Hewlett-Packard', 'Seagate');

-- Returns a list with the name and price of all products from manufacturers whose name ends with the vowel e.
SELECT p.name, p.price
FROM product p
JOIN manufacturer m ON p.manufacturer_code = m.code
WHERE RIGHT(m.name, 1) IN ('e');

-- Returns a list with the name and price of all products whose manufacturer name contains the character w in their name.
SELECT p.name, p.price
FROM product p
JOIN manufacturer m ON p.manufacturer_code = m.code
WHERE m.name LIKE '%w%';

-- Returns a list with the product name, price and manufacturer name, of all products that have a price greater than or equal to €180. Sort the result first by price (in descending order) and second by name (in ascending order).
SELECT p.name, p.price, m.name AS manufacturer_name
FROM product p
JOIN manufacturer m ON p.manufacturer_code = m.code
WHERE p.price >= 180
ORDER BY p.price DESC, p.name ASC;

-- Returns a list with the manufacturer's code and name, only of those manufacturers that have associated products in the database.
SELECT DISTINCT m.code, m.name
FROM manufacturer m
JOIN product p ON m.code = p.manufacturer_code;

-- Returns a list of all the manufacturers that exist in the database, along with the products that each of them has. The list must also show those manufacturers that do not have associated products.
SELECT m.code, m.name, p.name AS product_name, p.price
FROM manufacturer m
LEFT JOIN product p ON m.code = p.manufacturer_code;

-- Returns a list showing only those manufacturers that do not have any associated products.
SELECT m.code, m.name
FROM manufacturer m
LEFT JOIN product p ON m.code = p.manufacturer_code
WHERE p.manufacturer_code IS NULL;

-- Returns all products from the manufacturer Lenovo. (Without using INNER JOIN).
SELECT *
FROM product
WHERE manufacturer_code = (SELECT code FROM manufacturer where name = 'Lenovo');

-- Returns all data for products that have the same price as the most expensive product from the manufacturer Lenovo. (Without using INNER JOIN).
SELECT *
FROM product
WHERE price = (SELECT MAX(price) FROM product WHERE manufacturer_code = (SELECT code FROM manufacturer WHERE name = 'Lenovo'));

-- List the name of the most expensive product from the manufacturer Lenovo.
SELECT name
FROM product
WHERE manufacturer_code = (SELECT code FROM manufacturer WHERE name = 'Lenovo')
ORDER BY price DESC LIMIT 1;

-- List the cheapest product name from the manufacturer Hewlett-Packard.
SELECT name
FROM product
WHERE manufacturer_code = (SELECT code FROM manufacturer WHERE name = 'Hewlett-Packard')
ORDER BY price LIMIT 1;

-- Returns all products in the database that have a price greater than or equal to the most expensive product from manufacturer Lenovo.
SELECT *
FROM product
WHERE price >= (SELECT MAX(price) FROM product WHERE manufacturer_code = (SELECT code FROM manufacturer WHERE name = 'Lenovo'));

-- List all products from the manufacturer Asus that are priced higher than the average price of all their products.
SELECT p.*
FROM product p
JOIN manufacturer m ON p.manufacturer_code = m.code
WHERE m.name = 'Asus' AND p.price > (SELECT AVG(price) FROM product WHERE manufacturer_code = m.code);
