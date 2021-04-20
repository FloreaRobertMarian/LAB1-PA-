package main;

import model.Movies;
import repository.MovieRepository;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactorySingleton.createEntityManager();

        Movies movie = MovieRepository.findById("tt0013830");
        System.out.println(movie);
    }
}
