package pl.sda.Java8excercises;

import java.util.Optional;

/**
 * Created by Michał on 18-01-2017.
 */
public class Movie {
    private String title;
    private String genre;
    private int yearOfProduction;
    private int durationInMinutes;

    public Movie(String title, String genre, int yearOfProduction, int durationInMinutes) {
        this.title = title;
        this.genre = genre;
        this.yearOfProduction = yearOfProduction;
        this.durationInMinutes = durationInMinutes;
    }

    public Movie(String joinedDescription) {
        if (joinedDescription ==null){
            throw new IllegalArgumentException();
        }

    String[] splitDescription = joinedDescription.split(",");
        if (splitDescription.length!=4){
            throw new IllegalArgumentException();
        }
        this.title = splitDescription[0];
        this.genre = splitDescription[1];
        this.yearOfProduction = Integer.parseInt(splitDescription[2]);
        this.durationInMinutes = Integer.parseInt(splitDescription[3]);
    }

    public Movie(Optional<String> joinedDescriptionOptional) {
        String joinedDecriptionText =
        if (!joinedDescriptionOptional.isPresent()){
            throw new IllegalArgumentException();
        }



        String[] splitDescription = joinedDescriptionOptional.split(",");
        if (splitDescription.length!=4){
            throw new IllegalArgumentException();
        }
        this.title = splitDescription[0];
        this.genre = splitDescription[1];
        this.yearOfProduction = Integer.parseInt(splitDescription[2]);
        this.durationInMinutes = Integer.parseInt(splitDescription[3]);
    }


    //"Avengers,action,2010,120"

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    @Override
    public String toString() {
        return "MOVIE " +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", durationInMinutes=" + durationInMinutes +
                " min.";
    }
}
