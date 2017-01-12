package pl.sda;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        long start = System.nanoTime();
        for (int i = 0; i <10000000 ; i++) {

//            String converted = TextToMorseConverter.convert("ALA MA KOTA");
            String converted = TextToMorseConverter.translateToMorse("ALA MA KOTA");
        }
        System.out.println("Morse code");
//        System.out.println(converted);
        long stop = System.nanoTime();
        double duration = (stop - start)/1000000000d;
        System.out.println(duration);
    }
}
