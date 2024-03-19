# Midterm made on the 13th of March 2024
The following exam constitutes a midpoint on the academy's courses. It is made to evaluate how well the student has absorbed the materials they have been taught.

A time limit of 3 hours is imposed.

The assignment's instructions are as follows:

A fast food delivery company needs an order management program that allows it to carry out the
following functions:

- Create a new order
- Mark an order as delivered
- List pending orders
- List delivered orders

1. Orders have:
   1. An auto-incrementing ID
   2. A customer
   3. A list of products, and 
   4. A delivery person.
   
   When an order is created, a random delivery person who is available is assigned to it.
   When the order is delivered, the delivery person is released.

2. Customers have a name and a delivery address.

3. The delivery people have a name and availability to place an order. These can:
   1. go by bicycle, which increases the order price by 1%.
   2. ride a motorcycle, increasing the total order by 2%.
   3. go on foot.

4. The company has three types of products:
   1. Burritos. With a value of 6.5. When a customer buys a burrito they are given a pin.
   2. Burgers. Value 8.9. When a customer orders a hamburger, they are given a cap.
   3. Kebab. Price = 4.5
   4. Pizza. Price = 7.9.

5. When there are no longer available delivery people, an exception will be thrown that shows an error message
and do not allow creating a new order.
6. An order that does not have a customer or products cannot be created. You can handle it with an exception or a validation.