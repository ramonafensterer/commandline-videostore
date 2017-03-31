package cl_videostore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class MovieRepositoryTest {

	@Test
	@Ignore
	public void testGetMoviesWithCondition() {

		List<Movie> movies = new ArrayList<>();

		Movie movie1 = new Movie(0, "Film1", 1996, "REGULAR");
		movies.add(movie1);

		Movie movie2 = new Movie(1, "Film2", 1978, "CHILDREN");
		movies.add(movie2);

		Movie movie3 = new Movie(3, "Film3", 2004, "REGULAR");
		movies.add(movie3);

		MovieRepository underTest = null;
		try {
			underTest = new MovieRepository();
		} catch (IOException e) {
			fail("Exception when creating MovieRepository");
		}

		List<Movie> result1 = new ArrayList<>();

		result1.add(movie1);
		result1.add(movie2);

		List<Movie> result2 = new ArrayList<>();

		result2.add(movie3);

		assertEquals(result1, underTest.getMoviesWithCondition(movies, movie -> movie.getYear() < 2000));
		assertEquals(result2, underTest.getMoviesWithCondition(movies, movie -> movie.getYear() >= 2000));
	}

}
