# Level 2, Callback
Simulates a payment gateway that receives an object encapsulating the payment method to be made: credit card, Paypal or bank account debt.

The gateway will invoke the payment without knowing the form and returning control to the parent class.
The class that invokes the payment gateway will be a shoe store.