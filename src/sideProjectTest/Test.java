package sideProjectTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        List<String> cities = Arrays.asList(
                "Milan",
                "london",
                "San Francisco",
                "Tokyo",
                "New Delhi"
        );
        System.out.println(cities);
//[Milan, london, San Francisco, Tokyo, New Delhi]
        cities.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println(cities);
//[london, Milan, New Delhi, San Francisco, Tokyo]
        cities.sort(Comparator.naturalOrder());
        System.out.println(cities);
//[Milan, New Delhi, San Francisco, Tokyo, london]

        List<Integer> numbers = Arrays.asList(6, 2, 1, 4, 9);
        System.out.println(numbers); //[6, 2, 1, 4, 9]
        numbers.sort(Comparator.naturalOrder());
        System.out.println(numbers); //[1, 2, 4, 6, 9]

        List<Movie> movies = Arrays.asList(
                new Movie("Lord of the rings"),
                new Movie("Back to the future"),
                new Movie("Carlito's way"),
                new Movie("Pulp fiction"));
        movies.sort(Comparator.comparing(Movie::getTitle));
        movies.forEach(System.out::println);
    }

}

class Movie{

    Movie(){}

    Movie(String s){
     title = s;
    }

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}

