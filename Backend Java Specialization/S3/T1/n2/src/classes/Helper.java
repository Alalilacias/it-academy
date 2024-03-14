package S3.T1.n2.src.classes;

import S3.T1.n2.src.classes.agenda.Agenda;

import java.util.Scanner;

public class Helper extends Agenda {
    static Scanner s = new Scanner(System.in);
    public static void testExercise(){
        int option;
        while (true) {
            System.out.println("""
                Select your choice of action:
                1. See current agenda's contents.
                2. Introduce information to agenda.
                3. Exit.
                Write your number of choice here:
                """);
            option = s.nextInt();
            s.nextLine();

            switch (option){
                case 1:
                    getAgendaContents();
                    break;
                case 2:
                    introduceInformation();
                    break;
                case 3:
                    System.out.println("Closing system. Goodbye.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("That's not an option, try again.");
            }
        }
    }
}
