import java.util.*;

public class InvertedIndex {
    public static void main(String[] args) {
        List<Media> docs = List.of(
            new Book("Mistborn", "Brandon Sanderson",
                     new Scanner("Epic fantasy worldbuildling content")),
            new Book("Farenheit 451", "Ray Bradbury",
                     new Scanner("Realistic \"sci-fi\" content")),
            new Book("The Hobbit", "J.R.R. Tolkein",
                     new Scanner("Epic fantasy quest content"))
        );
        
        Map<String, Set<Media>> result = createIndex(docs);
        System.out.println(docs);
        System.out.println();
        System.out.println(result);
    }

    public static Map<String, Set<Media>> createIndex(List<Media> docs) {
        Map<String, Set<Media>> index = new TreeMap<>();

        for (Media doc : docs) {
            List<String> words = doc.getWords();
            for (String word : words) {
                word = word.toLowerCase();
                if (!index.containsKey(word)) {
                    index.put(word, new HashSet<>());
                }
                index.get(word).add(doc);
            }
        }
        return index;
    }
}
