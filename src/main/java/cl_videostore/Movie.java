package cl_videostore;

public class Movie {
    private final int key;
    private final String name;
    private final int year;
    private final String category;

    public Movie(int key, String name, int year, String category) {

        this.key = key;
        this.name = name;
        this.year = year;
        this.category = category;
    }

    public int getKey() {
        return key;
    }

    public String getName() {
        return name;
    }
    
    public int getYear() {
        return year;
    }

    public String getCategory() {
        return category;
    }
}
