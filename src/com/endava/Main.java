package com.endava;

import com.endava.models.Major;
import com.endava.models.Student;
import com.endava.models.User;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.endava.models.Gender.FEMALE;
import static com.endava.models.Gender.MALE;

public class Main {

    public static final List<User> USERS = Arrays.asList(new User("Vasea", MALE, 39),
            new User("Sveta", FEMALE, 30),
            new User("Jenea", MALE, 40),
            new User("Igor", MALE, 55),
            new User("Sveta", FEMALE, 30),
            new User("Jenea", MALE, 45));
    public static final List<String> STRINGS = Arrays.asList("String", "rabbit",
            "Cat", "Dog", "Cat", "Rabbit", "Elephant", "Fox", "Rabbit");

    public static final List<Student> STUDENTS = Arrays.asList(
            new Student("Valera", MALE, 18, new Major("Mathematics", 95)),
            new Student("NeValera", FEMALE, 20, new Major("Mathematics", 34)),
            new Student("Valera", MALE, 21, new Major("Mathematics", 13)),
            new Student("Valera", MALE, 18, new Major("Physics", 36)),
            new Student("NeValera", FEMALE, 20, new Major("Physics", 50)),
            new Student("Valera", MALE, 21, new Major("Physics", 84)),
            new Student("Valera", MALE, 18, new Major("Informatics", 51)),
            new Student("NeValera", FEMALE, 20, new Major("Informatics", 100)),
            new Student("Valera", MALE, 21, new Major("Informatics", 78))
            );

    public static void main(String args[]) {
        System.out.println("Count words in string");
        countWordsInString("cat dog rabbit dog cat fox elephant cat");
        printDelimiterLine();

        System.out.println("Persons with age > 40");
        System.out.println(findPersonsWithAgeHigher(USERS, 40));
        printDelimiterLine();

        System.out.println("Valera with highest score on each stream");
        findValeraWithHighestScoreOnEachMajor(STUDENTS);
        printDelimiterLine();

        System.out.println("Youngest user");
        Optional<User> user = extractYoungestUser(USERS);
        if(user.isPresent())
            System.out.println(user.get());
        printDelimiterLine();

        System.out.println("Sorted List of strings");
        System.out.println(sortListOfStringsAndRemoveDuplicates(STRINGS));
        }

    public static void printDelimiterLine() {
        System.out.println("\n-------------------------------------------------------\n");
    }

    public static void countWordsInString(String str){
        System.out.println(Stream.of(str.split("[ ]+"))
                .collect(Collectors.groupingBy(Object::toString, Collectors.counting())));
    }

    public static List<User> findPersonsWithAgeHigher(List<User> users, int age){
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    public static void findValeraWithHighestScoreOnEachMajor(List<Student> students){
        System.out.println(students.stream()
                .filter(student -> student.getName().equals("Valera"))
                .collect(Collectors.groupingBy(student -> student.getMajor().getName(),
                        Collectors.maxBy(Comparator.comparing(student -> student.getMajor().getScore())))));
    }

    public static Optional<User> extractYoungestUser(List<User> users){
        return users.stream()
                .min(Comparator.comparing(User::getAge));
    }

    public static List<String> sortListOfStringsAndRemoveDuplicates(List<String> strings){
        return strings.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
}
