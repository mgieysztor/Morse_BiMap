package pl.sda.Java8;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by RENT on 2017-01-11.
 */

public class TextToMorseConverterStream {
    public static String[] alpha = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
            "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8",
            "9", "0", " "};
    public static String[] dottie = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
            "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
            "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--..", ".----", "..---", "...--", "....-", ".....",
            "-....", "--...", "---..", "----.", "-----", "|"};
    public static BiMap<String, String> alphaMorse = HashBiMap.create();
    static {
        for (int i = 0; i < alpha.length; i++) {
            alphaMorse.put(alpha[i], dottie[i]);
        }

    }

    public static String convertStream (String text){

        String[] split = text.split("");

        for (String str:split) {
            System.out.println("Element: "+str);
        }

//        List<Stream> splitText = Arrays.stream(text.split("")).collect(toList);
//        Arrays.stream(split).map(x-> alpha.x.compareToIgnoreCase(alpha.));
//        List<Stream> splitText2 = Arrays.stream(split).forEach(x->S);




        return "AAA";
    }

    public static String convert(String text) {
        String[] split = text.split("");

        StringBuilder morseString = new StringBuilder();

        for (String element : split) {
            String convertedChar = convertChar(element,true);
            morseString.append(convertedChar);
            morseString.append(" ");
        }

        return morseString.toString();
    }

    public static String convertChar(String charToConvert, boolean toMorse) {

        if (toMorse) {
            charToConvert = charToConvert.toLowerCase();
            return (alphaMorse.get(charToConvert));
        } else {
            return alphaMorse.inverse().get(charToConvert);
        }
    }
}
