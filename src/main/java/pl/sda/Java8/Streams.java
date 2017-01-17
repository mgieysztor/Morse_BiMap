package pl.sda.Java8;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import pl.sda.Person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.partitioningBy;

/**
 * Created by Michał on 16-01-2017.
 */
public class Streams {
    public static void main(String[] args) {
        List<Integer> integersList = new ArrayList<>();
        integersList.add(1);
        integersList.add(16);
        integersList.add(6);
        integersList.add(11);
        integersList.add(2);
        integersList.add(8);
        integersList.add(30);

//        integers.stream().forEach(x -> System.out.println(x));
//        integers.forEach(x -> System.out.println(x));

//        integersList.stream().filter(x -> x < 10).forEach(x -> System.out.println(x));
//        integersList.stream().map(x->"Liczba "+x*x).forEach(x-> System.out.println(x));
//        boolean b = integersList.stream().anyMatch(x->x==8);
//        integersList.stream().filter(x -> x < 10).forEach(System.out::println);

        IntStream.range(0, 100).filter(x -> x % 2 == 0).forEach(x -> System.out.println(x));
        IntStream.range(0, 100).filter(x -> x % 2 == 0).boxed().collect(Collectors.toList()); //boxed przy IntStream przy stringu bez boxed()


        final int[] sum = {0};
        //reduce  - sprawdzić, nie miałem obrazu
        IntStream.range(0, 100).forEach(x -> sum[0] += x); //w foreach przypisywać możemy tylko do zmiennej final,
                                                            // przypisanie tablicy się nie zmienia, zmienia się jej zawartość
        System.out.println(sum[0]);


        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Jan", "Kowalski", 1980));
        personList.add(new Person("Piotr", "Mickiewicz", 1960));
        personList.add(new Person("Adam", "Mickiewicz", 1960));
        personList.add(new Person("Łukasz", "Mickiewicz", 1960));
        personList.add(new Person("Adam", "Adamski", 1970));
        personList.stream().filter(x -> x.getBirthYear() < 1970).forEach(x -> System.out.println(x));

//      1. zamienic liste osob na liste stringów :Imie nazwisko Jan, Kowalski
        personList.stream().forEach(x -> System.out.println(x.getFirstName() + ", " + x.getLastName()));
        List<String> firstLastNameList = personList.stream().map(x -> x.getFirstName() + ", "
                + x.getLastName()).collect(Collectors.toList());

//      2. za pomoca streamow sprwadzic czy liczba jest pierwsza streamy zagnieżdżone w sobie
//        System.out.println("Podaj liczbę do sprawdzenia, czy jest pierwsza.");
//        int x = new Scanner(System.in).nextInt();
//        IntStream.range(2, x / 2).filter();


        //zamiana tablicy na stream
        int[] ints = new int[10];
//        Arrays.stream(ints).
        System.out.println("=================");
        List<String> lastNames = personList.stream().map(p -> p.getLastName()).collect(Collectors.toList()); //tu można zaimportować klasę statyczną
        Set<String> lastNamesSet = personList.stream().map(p -> p.getLastName()).collect(Collectors.toSet()); //tu można zaimportować klasę statyczną
        lastNames.forEach(System.out::println);
        System.out.println("=================");
        lastNamesSet.stream().forEach(x -> System.out.println(x));

        //summaryStatistics
        List<Integer> birthYears = personList.stream().map(x -> x.getBirthYear()).collect(Collectors.toList());
        IntSummaryStatistics intSummaryStatistics = personList.stream().mapToInt(x -> x.getBirthYear()).summaryStatistics();
        double average = intSummaryStatistics.getAverage();
        int min = intSummaryStatistics.getMin();
        int max = intSummaryStatistics.getMax();
        long count = intSummaryStatistics.getCount();
        long sum1 = intSummaryStatistics.getSum();


        List<Integer> allPrimaryNumersLessThan = getAllPrimaryNumbersLessThan(1000);
        IntSummaryStatistics primaryNumbersStatistics
                = allPrimaryNumersLessThan.stream().mapToInt(x -> x).summaryStatistics();
        primaryNumbersStatistics.getCount();

        //partinioningBy dzieli na dwie grupu, spełniającą i niespełniającą warunek
        System.out.println("=============partitioningby============");
        Map<Boolean, List<Person>> collect2
                = personList.stream().collect(partitioningBy(x -> x.getBirthYear() < 1970));
        System.out.println("dla wartości TRUE");
        collect2.get(true).forEach(x -> System.out.println(x));
        System.out.println("dla wartości FALSE");
        collect2.get(false).forEach(x -> System.out.println(x));

        Map<Boolean, List<Person>> firstNamesMap
                = personList.stream().collect(partitioningBy(x -> x.getFirstName().startsWith("A")));
        List<Person> people = firstNamesMap.get(true);


        Map<Boolean, List<Person>> collect4
                = personList.stream().collect(partitioningBy(x -> x.getFirstName().toLowerCase().startsWith("a")));
        System.out.println("====================");
        System.out.println("Imię zaczyna się na A");
        System.out.println("dla wartości TRUE");
        firstNamesMap.get(true).forEach(x -> System.out.println(x));
        System.out.println("dla wartości FALSE");
        firstNamesMap.get(false).forEach(x -> System.out.println(x));
        System.out.println("====================");
        System.out.println("Imię zaczyna się na A z wykorzystaniem toLowerCase");
        System.out.println("dla wartości TRUE");
        collect4.get(true).forEach(x -> System.out.println(x));
        System.out.println("dla wartości FALSE");
        collect4.get(false).forEach(x -> System.out.println(x));

        //====================
        //groupingBy - grupuje wg wartości/klucza
        System.out.println("===groupingBy========");
        Map<String, List<Person>> collect3
                = personList.stream().collect(groupingBy(x -> x.getLastName()));
        Set<String> lastNames1 = collect3.keySet();
        for (String lastname:lastNames1             ) {
            System.out.println("WARTOSC KLUCZA "+lastname.toUpperCase());
            List<Person> persons = collect3.get(lastname);
            for (Person person: persons                 ) {
                System.out.println(person);
            }
        }

        List<Person> mickiewicz = collect3.get("Mickiewicz");
        List<Person> kowalski = collect3.get("kowalski");
        List<Person> admaski = collect3.get("adamski");

        //==============joining

        String joined = personList.stream().map(x -> x.getFirstName())
                .collect(joining(";", "IMIONA: ", " KONIEC"));
        System.out.println("=========joining========");
        System.out.println(joined);

        //pick sprawdzić
    }

    public static boolean isPrimaryStream(int x) {
//        return !IntStream.range(2, x / 2).anyMatch(y -> x % y == 0);
        return IntStream.range(2, x / 2).noneMatch(y -> x % y == 0);
    }

    public static List<Integer> getAllPrimaryNumbersLessThan(int x) {


        List<Integer> primaryNumbers = new ArrayList<>();
        for (int i = 2; i < x; i++) {
            if (isPrimaryStream(i)) {
                primaryNumbers.add(i);
            }
        }


        return primaryNumbers;
    }

    public static IntStream getAllPrimaryNumbersLessThanStream(int x) {
        return IntStream.range(2, x).filter(y -> isPrimaryStream(y));
    }

    public static List<Integer> getAllPrimaryNumbersLessThanStream2(int x) {
        return IntStream.range(2, x).filter(y -> isPrimaryStream(y)).boxed().collect(Collectors.toList());
    }


//        for (int i = 0; i <integers.size() ; i++) {
//            if (integers.get(i)>10){
//                integers.remove(i);
//
//            }
//        }
//
//        for (Integer integer: integers) {
//            System.out.println(integer);
//        }
}
