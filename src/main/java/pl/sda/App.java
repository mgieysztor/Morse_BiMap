package pl.sda;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String converted = TextToMorseConverter.convert("SOS");
        System.out.println("Morse code");
        System.out.println(converted);
    }
}
