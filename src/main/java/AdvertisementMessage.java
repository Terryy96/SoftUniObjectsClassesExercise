import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class AdvertisementMessage {
    private static final String[] laudatoryPhrases = {
            "Excellent product.",
            "Such a great product.",
            "I always use that product.",
            "Best product of its category.",
            "Exceptional product.",
            "I can’t live without this product."

    };

    private static final String[] events = {
            "Now I feel good.",
            "I have succeeded with this product.",
            "Makes miracles. I am happy of the results!",
            "I cannot believe but now I feel awesome.",
            "Try it yourself, I am very satisfied.",
            "I feel great!"

    };

    private static final String[] authors = {
            "Diana",
            "Petya",
            "Stella",
            "Elena",
            "Katya",
            "Iva",
            "Annie",
            "Eva"

    };

    private static final String[] cities = {
            "Burgas",
            "Sofia",
            "Plovdiv",
            "Varna",
            "Ruse"

    };

    public static String generateAd() {
        Random rand = new Random();

        // Select a random phrase, event, author, and city
        String phrase = laudatoryPhrases[rand.nextInt(laudatoryPhrases.length)];
        String event = events[rand.nextInt(events.length)];
        String author = authors[rand.nextInt(authors.length)];
        String city = cities[rand.nextInt(cities.length)];

        // Combine all parts to form the fake ad message
        return "\"" + phrase + " " + event + "\" - " + author + ", " + city;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println(generateAd());
        }

    }
}

//The format of the output message is: "{phrase} {event} {author} – {city}".