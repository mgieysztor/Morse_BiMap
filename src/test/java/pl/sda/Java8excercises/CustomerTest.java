package pl.sda.Java8excercises;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Michał on 18-01-2017.
 */
public class CustomerTest {
    @Test
    public void constructor_simpleTest(){
        //given
        String text = "Adam,Kowalski,1980,123";
        //when
        Customer customer = new Customer(text);
        //then
        assertEquals("Adam", customer.getFirstName());
        assertEquals("Kowalski", customer.getLastName());
        assertEquals(1980, customer.getBirthYear());
        assertEquals("123", customer.getIdNumber());
    }

    @Test
    public void constructor_wrongInputDefault(){
        //given
        boolean thrown = false;

        String text = "ABC";
        //when
        try {
            Customer customer = new Customer(text);
        } catch(IndexOutOfBoundsException e){
            thrown = true;
        }

        //then
        assertTrue(thrown);
    }

    @Test (expected = IllegalArgumentException.class)
    public void constructor_wrongInput(){
        //given
        String text = "ABC";
        //when
            Customer customer = new Customer(text);
    }

    @Test
    public void constructor_nullInputDefault(){
        //given
        boolean thrown = false;

        String text = null;
        //when
        try {
            Customer customer = new Customer(text);
        } catch(NullPointerException e){
            thrown = true;
        }

        //then
        assertTrue(thrown);
    }
}