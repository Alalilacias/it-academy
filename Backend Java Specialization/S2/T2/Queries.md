These are the queries to be made on each of the files:

# Store database

We have the product and manufacturer tables, each with the following fields:

- product (code, number, price, manufacturer_code)
- manufacturer (code, number)

The 'manufacturer_code' field of the product entity is related to the 'code' field of the manufacturer entity.

Please make the following inquiries:

- List the name of all the products in the product table.
- List the names and prices of all the products in the product table.
- List all columns of the product table.
- List the name of the products, the price in euros and the price in US dollars (USD).
- List the name of the products, the price in euros and the price in US dollars (USD). Use the following aliases for the columns: product name, euros, dollars.
- List the names and prices of all products in the product table, converting the names to uppercase. 
- List the names and prices of all products in the product table, converting the names to lowercase.
- List the name of all manufacturers in one column, and in another column obtain the first two characters of the manufacturer's name capitalized.
- List the names and prices of all products in the product table, rounding the price value.
- Lists the names and prices of all products in the product table, truncating the price value to display it without any decimal places.
- List the code of the manufacturers that have products in the product table.
- List the code of the manufacturers that have products in the product table, eliminating the codes that appear repeatedly.
- List manufacturer names in ascending order.
- List manufacturer names in descending order.
- List product names sorted first by name in ascending order and second by price in descending order.
- Returns a list with the first 5 rows of the manufacturer table.
- Returns a list with 2 rows starting from the fourth row of the manufacturer table. The fourth row must also be included in the answer.
- List the cheapest product name and price. (Use only the ORDER BY and LIMIT clauses). NOTE: I could not use MIN(price) here, I would need GROUP BY.
- List the name and price of the most expensive product. (Use only the ORDER BY and LIMIT clauses). NOTE: I could not use MAX(price) here, I would need GROUP BY.
- List the name of all products from the manufacturer whose manufacturer code is equal to 2.
- Returns a list with the product name, price, and manufacturer name of all products in the database.
- Returns a list with the product name, price, and manufacturer name of all products in the database. Sort the result by manufacturer name, in alphabetical order.
- Returns a list with the product code, product name, manufacturer code, and manufacturer name of all products in the database.
- Returns the name of the product, its price and the name of its manufacturer, of the cheapest product.
- Returns the name of the product, its price and the name of its manufacturer, of the most expensive product.
- Returns a list of all products from manufacturer Lenovo.
- Returns a list of all products from manufacturer Crucial that have a price greater than €200.
- Returns a list with all products from manufacturers Asus, Hewlett-Packard and Seagate. Without using the IN operator.
- Returns a list with all products from manufacturers Asus, Hewlett-Packard and Seagate. Using the IN operator.
- Returns a list with the name and price of all products from manufacturers whose name ends with the vowel e.
- Returns a list with the name and price of all products whose manufacturer name contains the character w in their name.
- Returns a list with the product name, price and manufacturer name, of all products that have a price greater than or equal to €180. Sort the result first by price (in descending order) and second by name (in ascending order).
- Returns a list with the manufacturer's code and name, only of those manufacturers that have associated products in the database.
- Returns a list of all the manufacturers that exist in the database, along with the products that each of them has. The list must also show those manufacturers that do not have associated products.
- Returns a list showing only those manufacturers that do not have any associated products.
- Returns all products from the manufacturer Lenovo. (Without using INNER JOIN).
- Returns all data for products that have the same price as the most expensive product from the manufacturer Lenovo. (Without using INNER JOIN).
- List the name of the most expensive product from the manufacturer Lenovo.
- List the cheapest product name from the manufacturer Hewlett-Packard.
- Returns all products in the database that have a price greater than or equal to the most expensive product from manufacturer Lenovo.
- List all products from the manufacturer Asus that are priced higher than the average price of all their products.

# University database

Please download the database from the schema_universidad.sql file, view the E-R diagram in an editor, and perform the following queries:

- Returns a list with the first last name, second last name and first name of all the students. The list must be ordered alphabetically from lowest to highest by first last name, second last name and first name.
- Find out the first and last names of students who have not registered their phone number in the database.
- Returns the list of students who were born in 1999.
- Returns the list of teachers who have not registered their phone number in the database and also their NIF ends in K.
- Returns the list of subjects that are taught in the first semester, in the third year of the degree that has the identifier 7.
- Returns a list of professors along with the name of the department to which they are linked. The listing should return four columns, first last name, second last name, first name and department name. The result will be sorted alphabetically from lowest to highest by last name and first name.
- Returns a list with the name of the subjects, start year and end year of the student's school year with NIF 26902806M.
- Returns a list with the name of all the departments that have professors who teach a subject in the Degree in Computer Science (Plan 2015).
- Returns a list of all students who have enrolled in a subject during the 2018/2019 school year.

Solve the following 6 queries using the LEFT JOIN and RIGHT JOIN clauses:
- Returns a list with the names of all the professors and the departments they are linked to. The list must also show those professors who do not have any associated department. The listing must return four columns, department name, first last name, second last name and teacher's name. The result will be sorted alphabetically from lowest to highest by department name, last name and first name.
- Returns a list of professors who are not associated with a department.
- Returns a list of departments that do not have associate professors.
- Returns a list of teachers who do not teach any subjects.
- Returns a list of subjects that do not have an assigned teacher.
- Returns a list of all departments that have not taught subjects in any school year.

Summary Queries:

- Returns the total number of students.
- Calculate how many students were born in 1999.
- Calculate how many teachers there are in each department. The result should only show two columns, one with the name of the department and another with the number of teachers in that department. The result must only include the departments that have associate professors and must be ordered from highest to lowest by the number of professors.
- Returns a list with all the departments and the number of professors in each of them. Keep in mind that there may be departments that do not have associate professors. These departments must also appear in the list.
- Returns a list with the name of all the existing degrees in the database and the number of subjects each one has. Note that there may be degrees that do not have associated subjects. These grades must also appear in the listing. The result must be ordered from highest to lowest by the number of subjects.
- Returns a list with the name of all the existing degrees in the database and the number of subjects each has, of the degrees that have more than 40 associated subjects.
- Returns a list showing the name of the degrees and the sum of the total number of credits for each subject type. The result must have three columns: name of the degree, type of subject and the sum of the credits of all subjects of that type.
- Returns a list that shows how many students have enrolled in a subject in each of the school years. The result must show two columns, one column with the start year of the school year and another with the number of enrolled students.
- Returns a list with the number of subjects taught by each teacher. The list must take into account those professors who do not teach any subjects. The result will show five columns: id, name, first last name, second last name and number of subjects. The result will be ordered from highest to lowest by the number of subjects.
- Returns all data for the youngest student.
- Returns a list of professors who have an associated department and who do not teach any subjects.