package pl.sda;

import java.util.Comparator;

/**
 * Created by RENT on 2017-01-12.
 */
public class PersonNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        return person1.getFirstName().compareTo(person2.getFirstName());

    }
}
