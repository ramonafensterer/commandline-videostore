package cl_videostore;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RentalRecord {
	private final List<Rental> rentals;
	private final String customerName;
	private MovieRepository movieRepository;

	public RentalRecord(MovieRepository movieRepository, List<Rental> rentals, String customerName) {
		this.movieRepository = movieRepository;
		this.rentals = rentals;
		this.customerName = customerName;
	}

	int getFrequentRenterPoints() {
		int frequentRenterPoints1 = 0;
		for (Rental rental1 : rentals) {
			frequentRenterPoints1 += rental1.getFrequentRenterPoints();
			// show figures for this rental
		}
		return frequentRenterPoints1;
	}

	double getTotalAmount() {
		double totalAmount1 = 0;
		for (Rental rental1 : rentals) {
			totalAmount1 += rental1.getAmount();
		}
		return totalAmount1;
	}

	public List<Rental> getRentals() {
		return rentals;
	}

	public String getCustomerName() {
		return customerName;
	}
	
	public Movie getMovieSuggestion(int year) {
		
		List<Movie> rentedMovies = rentals.stream().map(rental -> rental.movie).collect(Collectors.toList());
		List<Movie> rentedMoviesOlderThan = movieRepository.getMoviesWithCondition(rentedMovies, movie -> movie.getYear() < year);
		List<Movie> rentedMoviesNewerThan = movieRepository.getMoviesWithCondition(rentedMovies,
				movie -> movie.getYear() >= year);		 
		 
		Predicate<? super Movie> yearLimiter = movie -> movie.getYear() < year;
		Comparator<Movie> comparateByYear = (Movie m1, Movie m2) -> m1.getYear() - m2.getYear();
		List<Movie> preferenceMovies;
		
		if (rentedMoviesNewerThan.size() >= rentedMoviesOlderThan.size()) {
			yearLimiter = yearLimiter.negate();
			comparateByYear = comparateByYear.reversed();
			preferenceMovies = rentedMoviesNewerThan;
		} else {
			preferenceMovies = rentedMoviesOlderThan;
		}
		
		return movieRepository.getAllMoviesWithCondition(yearLimiter)
							  .stream()
			                  .filter(movie -> !preferenceMovies.contains(movie))
			                  .sorted(comparateByYear)
			                  .findFirst()
			                  .orElse(null);

	}

}
