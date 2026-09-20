import java.util.*;

public class StopWordFilteredWordFrequency {
    
    private static final Set<String> STOP_WORDS = new HashSet<>(Arrays.asList(
        "the", "was", "and", "a", "is", "of", "in"
    ));
    
    public static void printFilteredWordFrequency(String feedback) {
        // Normalize: lowercase and remove punctuation
        String cleaned = feedback.toLowerCase().replace(".", "").replace(",", "");
        
        // Split into words
        String[] words = cleaned.split("\\s+");
        
        // Count frequency excluding stop words
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            if (!STOP_WORDS.contains(word) && !word.isEmpty()) {
                freq.put(word, freq.getOrDefault(word, 0) + 1);
            }
        }
        
        // Sort by frequency descending
        List<Map.Entry<String, Integer>> sorted = new ArrayList<>(freq.entrySet());
        sorted.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        
        // Print results
        for (Map.Entry<String, Integer> entry : sorted) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    
    public static void main(String[] args) {
        printFilteredWordFrequency("The mentor was great, the session was great\nand clear.");
    }
}