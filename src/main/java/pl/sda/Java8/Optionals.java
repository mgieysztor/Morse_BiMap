package pl.sda.Java8;

import com.sun.corba.se.impl.io.OptionalDataException;

import javax.naming.event.ObjectChangeListener;
import java.awt.*;
import java.util.Optional;

/**
 * Created by Michał on 18-01-2017.
 */
public class Optionals {

    public static void main(String[] args) {
        // TWORZENIE OPTIONAL
        // 1. Optional.empty()
        Optional<Object> emptyOptional = Optional.empty();
        // 2. Optional.of(...)
        String a = "A";
        Optional<String> optional2 = Optional.of(a);
        Point point = new Point();
        Point pointNull = null;
//        Optional<Point> point1 = Optional.of(pointNull); // wywali, bo pointNull === null
        // 3. Optional.ofNullable(...)
        Optional<String> optional3 = Optional.ofNullable("ab");
        Optional<Point> optional31 = Optional.ofNullable(pointNull);
        String nullString = null;
        String ab = new String();
        Optional<String> testOptional = Optional.ofNullable(" ");
        // METODY OPTIONALI
        // 1. isPresent
        boolean isNotNull = testOptional.isPresent();
        Point nullPoint = null;
        Point nonNullPoint = new Point();
        Optional<Point> nonNullOptional = Optional.of(nonNullPoint);
        Optional<Point> nullOptional = Optional.ofNullable(nullPoint);
        boolean present = nullOptional.isPresent(); // present == false
        boolean present1 = nonNullOptional.isPresent(); // present == true
        // 2. get
        if (point != null) {
            point.getX();
        }
        if (nonNullOptional.isPresent()) {
            Point point1 = nonNullOptional.get();
            point1.getX();
        }
        if (testOptional.isPresent()) {
            String value = testOptional.get();
            value.charAt(1);
        }
        // 3. orElse
        String s11 = null;
        String value2 = Optional.ofNullable(s11).orElse(new String());
        Point point1 = new Point(100, 200);
        Optional<Point> pointOptional = Optional.ofNullable(point1);
        Point valueOfPoint = pointOptional.orElse(new Point());
        // 4. orElseGet
        String value3 = testOptional.orElseGet(() -> System.lineSeparator());
        // 5. orElseThrow
        String valu4 = testOptional.orElseThrow(() -> new IllegalArgumentException());
        // 6. filter
        String value5 = testOptional.filter(x -> !x.isEmpty()).orElse("BLA");
        String firstName = "Axxxxxx";
        Optional<String> firstName1 = Optional.ofNullable(firstName);
        firstName1.filter(x -> x.startsWith("A")).orElse("Default");
//        if(firstName != null){
//            if(firstName.startsWith("A")){
//                return firstName;
//            }
//            return "Default";
//        }
//        return "Default";
        // 7. map
        Optional<Double> bytes = pointOptional.map(x -> x.getX());
        // 8. ifPresent(Consumer)
        testOptional.ifPresent(x -> System.out.println(x));
        // 9. flatMap (map na metodzie zwracającej nulla)
//        Optional<U> b = Optional.ofNullable(Optional.of("B")).flatMap(x -> x.get());
    }

    public static int getStringLenght(Optional<String> s) {
        if (s.isPresent()) {
            return s.get().length();
        }
        return 0;
    }

    public static double pointsDistance(Point point1, Point point2) {
        if (point1 != null && point2 != null) {
            double distance =
                    Math.sqrt(
                            Math.pow(point1.getX() - point2.getX(), 2)
                                    + Math.pow(point1.getY() - point2.getY(), 2)
                    );
        }
        return 0;
    }

    public static double pointsDistance(Optional<Point> pointOptional1, Optional<Point> pointOptional2) {
        Point point1 = pointOptional1.orElse(new Point());
        Point point2 = pointOptional2.orElse(new Point());
        return
                Math.sqrt(
                        Math.pow(point1.getX() - point2.getX(), 2)
                                + Math.pow(point1.getY() - point2.getY(), 2)
                );
    }

}
