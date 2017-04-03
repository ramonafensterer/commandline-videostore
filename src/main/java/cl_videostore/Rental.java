package cl_videostore;

public abstract class Rental {
    Movie movie;
    int daysRented;

    protected Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    abstract double getAmount();

    public int getFrequentRenterPoints() {
        return 1;
    }

    public String getMovieName() {
        return movie.getName();
    }

	public int getMovieYear() {
		return movie.getYear();
	}
	
	@Override
	public String toString() {
		return "\t" +  getMovieName() + " (" + getMovieYear() + ")" + "\t" + getAmount() + "\n";
	}
}
