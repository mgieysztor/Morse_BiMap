package pl.sda.Java8excercises;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

/**
 * Created by Michał on 18-01-2017.
 */
public class Customer {
    private String firstName;
    private String lastName;
    private int birthYear;
    private String idNumber;

    public Customer(String firstName, String lastName, int birthYear, String idNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.idNumber = idNumber;
    }

    public Customer(String joinedData) {  //+testy
        List<String> splitInput = Arrays.stream(joinedData.split(","))
                .map(part -> part.toString()).collect(Collectors.toList());

        Optional<List> splitInputOptional = Optional.ofNullable(splitInput);

        this.firstName = splitInput.get(0);
        this.lastName = splitInput.get(1);
        this.birthYear = Integer.valueOf(splitInput.get(2));
//        this.birthYear = Integer.parseInt(splitInput.get(2)); alternatywa
        this.idNumber = splitInput.get(3);
//        String[] testSplit = joinedData.split(",");
//        this.firstName = testSplit[0];
//        this.lastName = testSplit[1];
//        this.birthYear = Integer.valueOf(testSplit[2]);
//        this.idNumber = testSplit[3];
//        Customer(splitInput.get(0),splitInput.get(1),Integer.valueOf(splitInput.get(2)), splitInput.get(3));


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

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthYear=" + birthYear +
                ", idNumber='" + idNumber + '\'' +
                '}';
    }
}
