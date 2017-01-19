package pl.sda.Java8excercises;

/**
 * Created by Michał on 18-01-2017.
 */
public class CustomerMain {
    public static void main(String[] args) {
        Customer customer1= new Customer("Adam,Kowalski,1980,123");
//        Customer customer2= new Customer("ABC");
        System.out.println(customer1.toString());
//        System.out.println(customer2.toString());
    }
}
