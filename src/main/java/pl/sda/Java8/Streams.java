package pl.sda.Java8;

import pl.sda.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
//        boolean b = integersList.stream().anyMatch(x ->x==8);
//        integersList.stream().filter(x -> x < 10).forEach(System.out::println);

        IntStream.range(0,100).filter(x->x%2==0).forEach(x-> System.out.println(x));
        IntStream.range(0,100).filter(x->x%2==0).boxed().collect(Collectors.toList()); //boxed przy IntStream przy stringu bez boxed()


        final int[] sum = {0};
        IntStream.range(0,100).forEach(x->sum[0]+=x);
        System.out.println(sum[0]);

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Jan", "Kowalski", 1980));
        personList.add(new Person("Piotr", "Mickiewicz", 1960));
        personList.add(new Person("Adam", "Mickiewicz", 1960));
        personList.add(new Person("Łukasz", "Mickiewicz", 1960));
        personList.add(new Person("Adam", "Adamski", 1970));
        personList.stream().filter(x   ->x.getBirthYear()<1970).forEach(x-> System.out.println(x));

//        1. zamienic liste osob na liste stringów :Imie nazwisko Jan, Kowalski
//                2. za pomoca streamow sprwadzic czy liczba jest pierwsza streamy zagnieżdżone w sobie

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
}
