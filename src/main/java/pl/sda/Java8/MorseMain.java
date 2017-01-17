package pl.sda.Java8;

/**
 * Created by Michał on 17-01-2017.
 */
public class MorseMain {
    public static void main(String[] args) {
        TextToMorseConverterStream.convertStream("SOS");
        TextToMorseConverterStreamJW.convert("ALA MA KOTA");
        System.out.println(TextToMorseConverterStreamJW.convert("ALA MA KOTA"));

    }
}
