package cl_videostore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Console {

	private final PrintStream out;
	private final RentalFactory rentalFactory;
	private final BufferedReader inputStreamReader;

	public Console(InputStream in, PrintStream out, RentalFactory rentalFactory) {
		this.out = out;
		this.rentalFactory = rentalFactory;
		this.inputStreamReader = new BufferedReader(new InputStreamReader(in));
	}

	public List<Rental> inputRentals() throws IOException {
		out.print("Choose movie by number followed by rental days, just ENTER for bill:\n");
		List<Rental> rentals = new ArrayList<>();
		while (true) {
			String input = inputStreamReader.readLine();
			if (input.isEmpty()) {
				break;
			}
			final Rental rental = rentalFactory.createFrom(input);
			rentals.add(rental);
		}
		return rentals;
	}

	public void printMovies(Collection<Movie> allMovies) {
		for (Movie movie : allMovies) {
			out.print(movie.getKey() + ": " + movie.getName() + " (" + movie.getYear() + ")\n");
		}
	}

	public String inputCustomerName() throws IOException {
		out.print("Enter customer name: ");
		return inputStreamReader.readLine();
	}

	public void printFooter(RentalRecord rentalRecord) {
		// add footer lines
		out.println("You owed " + rentalRecord.getTotalAmount());
		out.println("You earned " + rentalRecord.getFrequentRenterPoints() + " frequent renter points");

		Movie movieRecommendation = rentalRecord.getMovieSuggestion(2000);

		if (movieRecommendation != null) {
			out.println("Our recommendation for you: " + movieRecommendation.getName() + " ("
					+ movieRecommendation.getYear() + ").");
		}
	}

	public void printRentalRecord(RentalRecord rentalRecord) {
		out.print("Rental Record for " + rentalRecord.getCustomerName() + "\n");

		// TODO Exercise 3 Refactor this loop
		for (Rental rental : rentalRecord.getRentals()) {
			out.print("\t" + rental.getMovieName() + " (" + rental.getMovieYear() + ")" + "\t" + rental.getAmount()
					+ "\n");
		}
	}
}
