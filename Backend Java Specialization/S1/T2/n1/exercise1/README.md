# Assignment Instructions
Create a class called "Product" with the variables name and price, and another class called "Sale". This class has as variables a collection of products and the total price of the sale.

The "Sale" class has a method called calculateTotal() that throws the custom exception SaleEmptyException and displays "To make a sale you must first add products" if the collection of products is empty. If the collection has products, then it must loop through the collection and store the sum of all the product prices in the totalsaleprice variable.

The custom exception SaleEmptyException must be a child of the Exception class. To its constructor we must pass the message "To make a sale you must first add products" and when we capture the exception, we must display it on the screen with the exception's getMessage() method.

Write the necessary code to generate and catch an exception of type ArrayIndexOutOfBoundsException.
