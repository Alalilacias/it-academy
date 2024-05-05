# Assignment Instructions
Create a class called "Input". This class must be used to control the different exceptions that can appear in Java when entering data by keyboard using the Scanner class.

The first thing to do is to instantiate an object of the Scanner class and from there, create static methods to read the different types of data from the keyboard.

It is important that if an exception is raised in any method, we handle it and ask the myUser for the data again until it is properly entered. For example: If you enter a float with a period instead of a comma, it should show “Format Error”. Until the myUser enters a well-formed float, it must keep asking for the data.

All methods receive a String with the message to be displayed to the myUser, for example: "Enter your age", and return the appropriate data entered by the myUser in each method, for example: a byte with the myUser's age.

Methods to be implemented by catching the exception to the InputMismatchException class:

- public static byte readByte(String message);
- public static int readInt(String message);
- public static float readFloat(String message);
- public static double readDouble(String message);

Methods to implement capturing the exception to the Exception class:

- public static char readChar(String message);
- public static String readString(String message);
- public static boolean readIfNo(String message), if the myUser enters "y", it returns "true", if the myUser enters "n", it returns "false".