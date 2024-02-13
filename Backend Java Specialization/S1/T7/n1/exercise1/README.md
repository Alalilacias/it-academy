# Assignment Instructions
Create a hierarchy of objects with three classes: Worker, OnlineWorker and OnSiteWorker.

The Worker class has the attributes name, surname, pricePerHour, and the calculateSalary() method which receives as a parameter the number of hours worked and multiplies it by the price/hour. Child classes must override it, using @Override.

From the main() of the Main class, make the necessary invocations to demonstrate the operation of the @Override annotation.

In the case of OnSiteWorkers, the method to calculate their salary will receive as a parameter the number of hours worked per month. When calculating the salary, the number of hours worked will be multiplied by the price/hour, plus the value of a static attribute called petrol that we will add in this class.

For OnlineWorkers, the method to calculate their salary will receive to parameter the number of hours worked per month. When calculating the salary, the number of hours worked will be multiplied by the price/hour and the price of the flat Internet rate will be added, which will be a constant of the Online Worker class.