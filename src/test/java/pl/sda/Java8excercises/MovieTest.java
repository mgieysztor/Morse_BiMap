package pl.sda.Java8excercises;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Michał on 19-01-2017.
 */
public class MovieTest {
    @Test
    public void constructor_simpleTest(){
        //given
        String text = "Avengers,action,2010,120";
        //when
        Movie movie = new Movie(text);
        //then
        assertEquals("Avengers", movie.getTitle());
        assertEquals("action", movie.getGenre());
        assertEquals(2010, movie.getYearOfProduction());
        assertEquals(120, movie.getDurationInMinutes());
    }

    @Test
    public void constructor_wrongInputDefault(){
        //given
        boolean thrown = false;

        String text = "ABC";
        //when
        try {
            Movie movie = new Movie(text);
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
        Movie movie = new Movie(text);
    }

    @Test
    public void constructor_nullInputDefault(){
        //given
        boolean thrown = false;

        String text = null;
        //when
        try {
            Movie movie = new Movie(text);
        } catch(NullPointerException e){
            thrown = true;
        }

        //then
        assertTrue(thrown);
    }

}