/* This class represents a book and implements the Media interface and provides methods 
to get the title, authors, ratings, and words associated with the book. 
It also allows setting a query for ranking purposes and implements 
the Comparable interface to rank books based on the query, words and ratings */
import java.util.*;

public class Book implements Media, Comparable<Book> {
    private String title;
    private List<String> authors;
    private List<Integer> ratings;
    private List<String> words;
    private String currentQuery;

    // Constructor that initializes the book with the provided title and single author
    // Parameters:
    //   - title: String representing the title of the book
    //   - author: String representing the author of the book
    public Book(String title, String author) {
        this.title = title;
        this.authors = new ArrayList<>();
        this.authors.add(author);
        this.ratings = new ArrayList<>();
        this.words = new ArrayList<>();
    }

    // Constructor that initializes the book with the provided title and multiple authors
    // Parameters:
    //   - title: String representing the title of the book
    //   - authors: List of strings representing the authors of the book
    public Book(String title, List<String> authors) {
        this.title = title;
        this.authors = new ArrayList<>(authors);
        this.ratings = new ArrayList<>();
        this.words = new ArrayList<>(); 
    }

    // Constructor that initializes the book with the provided title, author, and Scanner
    // Parameters:
    //   - title: String representing the title of the book
    //   - author: String representing the author of the book
    //   - sc: Scanner object to read the words of the book
    public Book(String title, String author, Scanner sc) {
        this.title = title;
        this.authors = new ArrayList<>();
        this.authors.add(author);
        this.ratings = new ArrayList<>();
        this.words = new ArrayList<>();

        while (sc.hasNext()) {
            this.words.add(sc.next());
        }
    }

    // Gets the title of the book
    // Returns:
    //   - String representing the title of the book
    public String getTitle() { 
        return this.title;
    }

    // Gets the authors of the book
    // Returns:
    //   - List of strings representing the authors of the book
    public List<String> getArtists() {
        return new ArrayList<>(this.authors);
    }

    // Adds a rating to the book
    // Parameters:
    //   - score: Integer representing the score for the new rating. Should be non-negative.
    public void addRating (int score) {
        if (score >= 0) {
            this.ratings.add(score);
        }
    }
    
    // Gets the number of ratings for the book
    // Returns:
    //   - Integer representing the number of ratings for the book
    public int getNumRatings() {
        return this.ratings.size();
    }

    // Gets the average rating of the book
    // Returns:
    //   - Double representing the average rating of the book. If no ratings exist, returns 0.  
    public double getAverageRating() {
        if (this.ratings.isEmpty()) {
            return 0;
        }

        int sum = 0;

        for (int rating : this.ratings) {
            sum += rating;
        }
        return (double) sum / ratings.size();
    }

    // Gets the words contained in the book
    // Returns:
    //   - List of strings representing the words in the book. If no words are known, returns an empty list.
    public List<String> getWords() {
        return new ArrayList<>(this.words);
    }

    // Produces a readable string representation of the book
    // Returns:
    //   - String representing the book in the format "<title> by [<authors>]: <average rating> (<num ratings> ratings)"
    @Override
    public String toString() {
        String result = this.title + " by " + this.authors;

        if (this.ratings.isEmpty()) {
            return result;
        } 
        else {
            double averageRating = getAverageRating();
            double roundedRating = Math.round(averageRating * 100.0) / 100.0;

            int numRatings = getNumRatings();
            result += ": " + roundedRating + " (" + numRatings + " ratings)";

            return result;
        }
    }

    // Sets the current query for the book
    // Parameters:
    //   - query: String representing the query to set
    public void setQuery(String query) {
        this.currentQuery = query;
    }

    // Compares this book to another book for ranking purposes
    // Parameters:
    //   - other: Book object to compare to
    // Returns:
    //   - Integer denoitng the comparison result: -1 is less relevant, 1 is more relevant, 0 is equally relevant
    @Override
    public int compareTo(Book other) {
    int thisCount = 0;

    for (String word : this.words) {
        if (word.equalsIgnoreCase(this.currentQuery)) {
            thisCount++;
        }
    }

    int otherCount = 0;

    for (String word : other.words) {
        if (word.equalsIgnoreCase(other.currentQuery)) {
            otherCount++;
        }
    }

    if (thisCount < otherCount) {
        return -1;
    }
    else if (thisCount > otherCount) {
        return 1;
    } 
    else {
        // If counts are equal, use average rating as a tiebreaker
        double thisRating = this.getAverageRating();
        double otherRating = other.getAverageRating();

        if (thisRating < otherRating) {
            return -1;
        }
        else if (thisRating > otherRating) {
            return 1;
        }
        else {
            return 0;
        }
    }
    
    }
}