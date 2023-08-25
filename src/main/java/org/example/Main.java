package org.example;

import Cine.Movie;
import Cine.MovieTheater;
import Cine.Person;
import com.github.javafaker.Faker;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // populateCinemas("Pinocchio", 114, 15, "Guillermo del Toro", 20000, 50);
        /*
        Faker faker = new Faker();
        Movie movie = new Movie("Pinocchio",114,15, "Guillermo del Toro");
        MovieTheater theater = new MovieTheater(20000, movie);

        for(int i = 0; i < 50; i++){    //Create 50 people
            theater.checkInPerson(new Person(faker.name().fullName(), faker.number().numberBetween(15,55), faker.number().numberBetween(2000,100000)));
            System.out.println(theater);
        }
        */

        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Matilda", 98, 5, "Danny DeVito"));
        movies.add(new Movie("Insidious:the red door", 107, 18, "Patrick Wilsom"));
        movies.add(new Movie("Pinocchio", 114, 15, "Guillermo del Toro"));
        movies.add(new Movie("Oppenheimer", 180, 15, " Christopher Nolan"));
        movies.add(new Movie("Evil Dead", 96, 10, " Lee Cronin"));

        ArrayList<MovieTheater> theaters = new ArrayList<>();
        for (Movie movie : movies) {
            theaters.add(new MovieTheater(20000, movie));
        }

        Faker faker = new Faker();
        for(int i = 0; i < 200; i++){    //Create 200 people
            Person person = new Person(faker.name().fullName(), faker.number().numberBetween(5,55), faker.number().numberBetween(2000,100000));
            int theaterNumber = faker.number().numberBetween(0, theaters.size());
            MovieTheater theater = theaters.get(theaterNumber);
            System.out.println("Teather with movie " + theater.getMovie().getTittle() + " was selected");
            theater.checkInPerson(person);
        }
        for (MovieTheater theater :theaters) {
            System.out.println("Teather with movie " + theater.getMovie().getTittle());
            System.out.println(theater);
        }




    }

    public static MovieTheater populateCinemas(String movieName, int movieLength, int minimunAnge, String directorName,
                                        int ticketPrice, int people) {
        Faker faker = new Faker();
        Movie movie = new Movie(movieName,movieLength,minimunAnge, directorName);
        MovieTheater theater = new MovieTheater(ticketPrice, movie);

        for(int i = 0; i < people; i++){    //Create 50 people
            theater.checkInPerson(new Person(faker.name().fullName(), faker.number().numberBetween(15,55), faker.number().numberBetween(2000,100000)));
            System.out.println(theater);
        }
        return theater;
    }
}