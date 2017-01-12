package pl.sda;

/**
 * Created by RENT on 2017-01-12.
 */
public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private int birthYear;

    public Person(String firstName, String lastName, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }

    @Override
    public String toString() {
        return "Osoba o imieniu: " + firstName
                + ", nazwisku: " + lastName
                + " i roku urodzenia: " + birthYear + ".";
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Person)) return false;
//
//        Person person = (Person) o;
//
//        if (birthYear != person.birthYear) return false;
//        if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) return false;
//        return lastName != null ? lastName.equals(person.lastName) : person.lastName == null;
//    }
    //

    @Override
    public boolean equals(Object obj) {//działa ale brakuje sprawdzenia nulli
        Person person = (Person) obj;
        if (this.firstName.equals(person.firstName)
                && (this.lastName.equals(person.lastName)
                && (this.birthYear == person.birthYear))) {
            return true;
        } else {
            return false;
        }
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    @Override
    public int compareTo(Person o) {
        if (this.birthYear < o.birthYear) {
            return -1;
        } else if (this.birthYear == o.birthYear) {
            return 0;
        } else {
            return 1;
        }
    }
}
