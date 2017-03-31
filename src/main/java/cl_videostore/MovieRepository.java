package cl_videostore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class MovieRepository {

	private Map<Integer, Movie> movies;

	public MovieRepository() throws IOException {
		// read movies from file
		final InputStream movieStream = Main.class.getResourceAsStream("/movies.cvs");
		final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(movieStream));
		movies = new HashMap<>();
		while (bufferedReader.ready()) {
			final String line = bufferedReader.readLine();
			final String[] movieData = line.split(";");
			Movie movie = new Movie(Integer.parseInt(movieData[0]), movieData[1], Integer.parseInt(movieData[2]),
					movieData[3]);
			movies.put(movie.getKey(), movie);
		}
	}

	public Collection<Movie> getAllMovies() {
		return movies.values();
	}

	public Movie getByKey(int key) {
		return movies.get(key);
	}

	public List<Movie> getMoviesWithCondition(List<Movie> movies, Predicate<? super Movie> predicate) {
		//TODO Exercise 1
		
		return Collections.emptyList();
	}
}
