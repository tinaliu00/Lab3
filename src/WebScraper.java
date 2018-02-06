import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {

    public static void main(final String[] unused) {
        Scanner lineScanner = new Scanner(System.in);
        System.out.println("Enter a URL: ");
        String url = lineScanner.nextLine();
        System.out.println("Enter a word to look for: ");
        String lookFor = lineScanner.nextLine();
        String contents = urlToString(url);
        String[] arrayOfContents = contents.split("\n");
        int containsTimes = 0;
        for (int i = 0; i < arrayOfContents.length; i++) {
            if (arrayOfContents[i].contains(lookFor)) {
                containsTimes++;
            }
        }
        System.out.println(containsTimes);
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
}
