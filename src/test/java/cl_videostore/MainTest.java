package cl_videostore;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Simple pin-down test. Do not use this as an example for a good test ;-)
 */
public class MainTest {

    @Test
    public void run_fullCoverage() throws Exception {
        final String consoleInput =
                "John Doe\n" +
                "0 1\n" +
                "2 3\n" +
                "6 1\n" +
                "9 1\n" +
                "10 2\n" +
                "13 5\n" +
                "\n";
        final ByteArrayOutputStream consoleOutputStream = new ByteArrayOutputStream();

        new Main(
                new ByteArrayInputStream(consoleInput.getBytes(StandardCharsets.UTF_8)),
                new PrintStream(consoleOutputStream)
        ).run();

        assertEquals("0: The Shawshank Redemption (1994)\n" +
                        "1: The Godfather (1972)\n" +
                        "2: The Godfather: Part II (1974)\n" +
                        "3: The Dark Knight (2008)\n" +
                        "4: Pulp Fiction (1994)\n" +
                        "5: The Good, the Bad and the Ugly (1966)\n" +
                        "6: The Lord of the Rings: The Return of the King (2003)\n" +
                        "7: Fight Club (1999)\n" +
                        "8: The Lord of the Rings: The Fellowship of the Ring (2001)\n" +
                        "9: Interstellar (2014)\n" +
                        "10: Whiplash (2014)\n" +
                        "11: Birdman (2014)\n" +
                        "12: Up (2009)\n" +
                        "13: WALL·E (2008)\n" +
                        "Enter customer name: Choose movie by number followed by rental days, just ENTER for bill:\n" +
                        "Rental Record for John Doe\n" +
                        "\tThe Shawshank Redemption (1994)\t2.0\n" +
                        "\tThe Godfather: Part II (1974)\t3.5\n" +
                        "\tThe Lord of the Rings: The Return of the King (2003)\t1.5\n" +
                        "\tInterstellar (2014)\t3.0\n" +
                        "\tWhiplash (2014)\t6.0\n" +
                        "\tWALL·E (2008)\t4.5\n" +
                        "You owed 20.5\n" +
                        "You earned 7 frequent renter points\n" + 
                        "Our recommendation for you: Birdman (2014).\n",
                consoleOutputStream.toString("UTF-8"));
    }
    
    @Test
    public void run_fullCoverage_another_test() throws Exception {
        final String consoleInput =
                "John Doe\n" +
                "0 1\n" +
                "1 1\n" +
                "\n";
        final ByteArrayOutputStream consoleOutputStream = new ByteArrayOutputStream();

        new Main(
                new ByteArrayInputStream(consoleInput.getBytes(StandardCharsets.UTF_8)),
                new PrintStream(consoleOutputStream)
        ).run();

        assertEquals("0: The Shawshank Redemption (1994)\n" +
                        "1: The Godfather (1972)\n" +
                        "2: The Godfather: Part II (1974)\n" +
                        "3: The Dark Knight (2008)\n" +
                        "4: Pulp Fiction (1994)\n" +
                        "5: The Good, the Bad and the Ugly (1966)\n" +
                        "6: The Lord of the Rings: The Return of the King (2003)\n" +
                        "7: Fight Club (1999)\n" +
                        "8: The Lord of the Rings: The Fellowship of the Ring (2001)\n" +
                        "9: Interstellar (2014)\n" +
                        "10: Whiplash (2014)\n" +
                        "11: Birdman (2014)\n" +
                        "12: Up (2009)\n" +
                        "13: WALL·E (2008)\n" +
                        "Enter customer name: Choose movie by number followed by rental days, just ENTER for bill:\n" +
                        "Rental Record for John Doe\n" +
                        "\tThe Shawshank Redemption (1994)\t2.0\n" +
                        "\tThe Godfather (1972)\t2.0\n" +
                        "You owed 4.0\n" +
                        "You earned 2 frequent renter points\n" + 
                        "Our recommendation for you: The Good, the Bad and the Ugly (1966).\n",
                consoleOutputStream.toString("UTF-8"));
    }
    
    //TODO Activate test for exercise 4
   // @Test
//	public void testQuoteLine() throws Exception {
//		final String consoleInput = "John Doe\n" + "0 1\n" + "1 1\n" + "\n";
//		final ByteArrayOutputStream consoleOutputStream = new ByteArrayOutputStream();
//
//		new Main(new ByteArrayInputStream(consoleInput.getBytes(StandardCharsets.UTF_8)),
//				new PrintStream(consoleOutputStream)).run();
//
//		String fileContent = new String(Files.readAllBytes(Paths.get("invoice.txt")));
//		
//		int lastIndexOfNewLine = fileContent.lastIndexOf("\n\n");
//		
//		String quoteInFile = fileContent.substring(lastIndexOfNewLine + 2, fileContent.length() - 1);
//		
//		QuotesRepository quotesRepo = new QuotesRepository();
//		List<String> allQuotes = quotesRepo.getAllQuotes();
//		assertTrue(allQuotes.contains(quoteInFile));
//	}
}