package se.lexicon;

import se.lexicon.data.DataStorage;
import se.lexicon.model.Gender;
import se.lexicon.model.Person;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Exercises {

    private final static DataStorage storage = DataStorage.INSTANCE;


    public static void exercise1(String message) {
        System.out.println(message);
        List<Person> persons = storage.findMany(person -> person.getFirstName().equals("Erik"));
        persons.forEach(System.out::println);

        System.out.println("----------------------");
    }


    public static void exercise2(String message) {
        System.out.println(message);
        List<Person> persons = storage.findMany(person -> person.getGender().equals(Gender.FEMALE));
        persons.forEach(System.out::println);


        System.out.println("----------------------");
    }

    public static void exercise3(String message) {
        System.out.println(message);
        List<Person> persons = storage.findMany(person -> !person.getBirthDate().isBefore(LocalDate.of(2000,01,1)));
        persons.forEach(System.out::println);

        System.out.println("----------------------");
    }

    public static void exercise4(String message) {
        System.out.println(message);
        Person person = storage.findOne(person1 -> person1.getId()==123);
        System.out.println(person);

        System.out.println("----------------------");
    }

    public static void exercise5(String message) {
        System.out.println(message);
        System.out.println(storage.findOneAndMapToString(person1 -> person1.getId() == 456, person1 -> "Name: " + person1.getFirstName() + " " +person1.getLastName() + " born " + person1.getBirthDate() + "."));

        System.out.println("----------------------");
    }

    public static void exercise6(String message) {
        System.out.println(message);

        storage.findManyAndMapEachToString(person -> person.getGender().equals(Gender.MALE) &&
                person.getFirstName().startsWith("E"),
                person -> "Name: " + person.getFirstName() + " " + person.getLastName())
                .forEach(System.out::println);


        System.out.println("----------------------");
    }


    public static void exercise7(String message) {
        System.out.println(message);

        int currentYear = LocalDate.now().getYear();
        int cutoffYear = currentYear - 10;


        storage.findManyAndMapEachToString(
                person -> person.getBirthDate().getYear() >cutoffYear,
                person -> person.getFirstName() + " " + person.getLastName() + " " +
                        (currentYear - person.getBirthDate().getYear()) + " years.")
                                .forEach(System.out::println);

        System.out.println("----------------------");
    }


    public static void exercise8(String message) {
        System.out.println(message);

        storage.findAndDo(person -> person.getFirstName().equals("Ulf"), person -> System.out.println(person));

        System.out.println("----------------------");
    }

    public static void exercise9(String message) {
        System.out.println(message);

        storage.findAndDo(person -> person.getLastName().contains(person.getFirstName()), person -> System.out.println(person));

        System.out.println("----------------------");
    }

    /**
     * 10.	TODO: Using findAndDo() print out the firstName and lastName of everyone whose firstName is a palindrome.
     */
    public static void exercise10(String message) {
        System.out.println(message);

        storage.findAndDo(person ->
                { String name = person.getFirstName();
                        return new StringBuilder(name).reverse().toString().equalsIgnoreCase(name);
        },
                person -> System.out.println(person.getFirstName() + " " + person.getLastName())
        );

        System.out.println("----------------------");
    }

    /**
     * 11.	TODO: Using findAndSort() find everyone whose firstName starts with A sorted by birthdate.
     */
    public static void exercise11(String message) {
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }

    /**
     * 12.	TODO: Using findAndSort() find everyone born before 1950 sorted reversed by lastest to earliest.
     */
    public static void exercise12(String message) {
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }

    /**
     * 13.	TODO: Using findAndSort() find everyone sorted in following order: lastName > firstName > birthDate.
     */
    public static void exercise13(String message) {
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }

}