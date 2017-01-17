package pl.sda.Java8;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;

/**
 * Created by RENT on 2017-01-11.
 */

public class TextToMorseConverterStreamJW {
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

    public static String convert (String text) {
//        return Arrays.stream(text.split(""))
//                .map(letter-> convertChar(letter,false))
//                .collect(joining(" "));

//        return Arrays.stream(text.split(""))
//                .map(letter-> alphaMorse.get(letter.toLowerCase()))
//                .collect(joining(" "));

        return Arrays.stream(text.split(""))
                .map(letter-> alphaMorse.get(letter.toLowerCase()))
                .collect(joining(" "));


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
