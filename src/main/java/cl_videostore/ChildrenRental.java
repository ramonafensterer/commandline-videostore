package cl_videostore;

public class ChildrenRental extends Rental {

    public ChildrenRental(Movie movie, int daysRented) {
        super(movie, daysRented);
    }

    @Override
    public double getAmount() {
        if (daysRented > 3) {
            return (daysRented - 2) * 1.5;
        }

        return 1.5;
    }
}
