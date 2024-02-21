# Assignment Instructions
You have been hired to design a website that allows you to order food at home via the Internet.

Consider the following guidelines for modeling what the project's database would look like:

For each customer we store a unique identifier:
- First name.
- Surnames.
- Address.
- Postal code.
- County.
- Province.
- Phone number.
- The locality and province data will be stored in separate tables. We know that a locality belongs to a single province, and that a province can have many localities. For each locality we store a unique identifier and a name. For each province we store a unique identifier and a name.

A person can place many orders, but a single order can only be placed by a single person.

A unique identifier is stored for each order:
- Date/time
- If the order is for home delivery or to pick up in store.
- The amount of products that have been selected of each type.
- The total price.

An order can consist of one or several products.
- Products can be pizzas, hamburgers and drinks.
  - A unique identifier is stored for each product:
    - First name.
    - Description.
    - image
    - price
    
- In the case of pizzas, there are several categories that can change names throughout the year. A pizza can only be in one category, but a category can have many pizzas. A unique identifier and a name are stored for each category.

- An order is handled by a single store and a store can handle many orders.
  - A unique identifier is stored for each store:
    - Address.
    - Postal code.
    - Location.
    - Province.

- Many employees can work in one store but one employee can only work in one store.
  - For each employee, a unique identifier is stored:
    - First name.
    - Surnames.
    - NIF.
    - Phone
    - If you work as a cook or delivery person.
    - For home delivery orders, it is important to save whom the delivery person is and the date/time of delivery.