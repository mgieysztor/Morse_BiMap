package pl.sda;

import java.text.Collator;
import java.util.*;

/**
 * Created by RENT on 2017-01-12.
 */
public class PersonMain {
    public static void main(String[] args) {
//        Person person1 = new Person("Jan", "Kowalski", 1998);
//        Person person2 = new Person("Adam", "Mickiewicz", 1970);
//        Person person3 = new Person("Adam", "Adamski", 1970);
//
//        List<Person> personList = new ArrayList<>();
//        personList.add(person1);
//        personList.add(person2);
//
////        System.out.println(personList.contains(person1));
////        Person person3 = new Person("Jan", "Kowalski", 1998);
////        System.out.println(personList.contains(person3));
//        personList.add(person3);
//        for (Person person:personList) {
//            System.out.println(person);
//        }
        List personList = new ArrayList<>();
        personList.add(new Person("Jan", "Kowalski", 1980));
        personList.add(new Person("Waldemar", "Mickiewicz", 1960));
        personList.add(new Person("Piotr", "Mickiewicz", 1960));
        personList.add(new Person("Adam", "Mickiewicz", 1970));
        personList.add(new Person("Franciszek", "Mickiewicz", 1970));
        personList.add(new Person("Łukasz", "Mickiewicz", 1970));
        personList.add(new Person("Edward", "Wojciechowski", 1970));
        personList.add(new Person("Adam", "Kowalski", 1970));

//        String s1 = "A";
//        String s2 = "B";
//        System.out.println(s1.compareTo(s2));

//        Collections.sort(personList, new PersonBirthYearComparator());
//        Collections.sort(personList, new PersonNameComparator());

        Collections.sort(personList,
                new Comparator<Person>() {  //to jest klasa anonimowa
                    private Collator c = Collator.getInstance(new Locale("pl", "PL"));
                    @Override
                    public int compare (Person person1, Person person2) {
                        if (c.compare(person1.getLastName(),person2.getLastName())==0){
                            return c.compare(person1.getFirstName(),person2.getFirstName());
                        } return c.compare(person1.getLastName(),person2.getLastName());
                    }
                }
        );
        for (
                Object object : personList)

        {
            System.out.println(object);
        }

    }
}
