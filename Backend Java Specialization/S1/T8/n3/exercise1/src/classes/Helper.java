package S1.T8.n3.exercise1.src.classes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Helper {
    @SuppressWarnings("FieldMayBeFinal")
    private static List<Student> studentList = Arrays.asList(
            new Student.Builder()
                    .name("Manuel")
                    .age(25)
                    .course("Java")
                    .grade(8)
                    .build(),

            new Student.Builder()
                    .name("Juana")
                    .age(30)
                    .course("PHP")
                    .grade(5)
                    .build(),

            new Student.Builder()
                    .name("Gabriela")
                    .age(45)
                    .course("Javascript")
                    .grade(2)
                    .build(),

            new Student.Builder()
                    .name("Herminia")
                    .age(85)
                    .course("PHP")
                    .grade(9)
                    .build(),

            new Student.Builder()
                    .name("Góngora")
                    .age(350)
                    .course("Python")
                    .grade(6)
                    .build(),

            new Student.Builder()
                    .name("Rigoberto")
                    .age(52)
                    .course("Java")
                    .grade(5)
                    .build(),

            new Student.Builder()
                    .name("Hortensia")
                    .age(69)
                    .course("PHP")
                    .grade(5)
                    .build(),

            new Student.Builder()
                    .name("Guillermina")
                    .age(420)
                    .course("Python")
                    .grade(5)
                    .build(),

            new Student.Builder()
                    .name("Bonifaci")
                    .age(0)
                    .course("PHP")
                    .grade(5)
                    .build(),

            new Student.Builder()
                    .name("Alberico")
                    .age(38)
                    .course("Javascript")
                    .grade(5)
                    .build()
    );

    protected static void testExercise(){
        printNamesAndAges(studentList);

        List<Student> studentsWhoseNameStartsWithA = filterStudentsByA(studentList);

        Stream.concat(
                Stream.of("These students' names start with 'A':"),
                studentsWhoseNameStartsWithA.stream()
                        .map(s -> "- Name: " + s.getName() + ", course: " + s.getCourse())
        ).forEach(System.out::println);

        printPassedStudents(studentList);

        printNonPHPPassedStudents(studentList);

        printLegallyEnrolledJavaStudents(studentList);
    }

    private static void printNamesAndAges(List<Student> list){
        Stream.concat(
                Stream.of("These are the students enrolled at this moment:"),
                list.stream()
                    .map(s -> "- Name: " + s.getName() + ", age: " + s.getAge())
        ).forEach(System.out::println);
    }
    private static List<Student> filterStudentsByA(List<Student> list){
        return list.stream()
                    .filter(s -> s.getName().startsWith("A"))
                    .collect(Collectors.toList());
    }
    private static void printPassedStudents(List<Student> list){
        Stream.concat(
                Stream.of("These students have passed the class: "),
                list.stream()
                    .filter(s -> s.getGrade() > 4)
                    .map(s -> "- Name: " + s.getName() + ", grade: " + s.getGrade())
        ).forEach(System.out::println);
    }
    private static void printNonPHPPassedStudents(List<Student> list){
        Stream.concat(
                Stream.of("These students that don't study PHP have passed the class: "),
                list.stream()
                        .filter(s -> s.getGrade() > 4 && !s.getCourse().equals("PHP") )
                        .map(s -> "- Name: " + s.getName() + ", grade: " + s.getGrade())
        ).forEach(System.out::println);
    }
    private static void printLegallyEnrolledJavaStudents(List<Student> list){
        Stream.concat(
                Stream.of("These Java students can legally vote: "),
                list.stream()
                        .filter(s -> s.getAge() > 18 && s.getCourse().equals("Java") )
                        .map(s -> "- Name: " + s.getName() + ", age: " + s.getAge())
        ).forEach(System.out::println);
    }
}
