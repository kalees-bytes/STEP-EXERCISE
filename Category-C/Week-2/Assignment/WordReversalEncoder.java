public class WordReversalEncoder {
    
    public static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
            if (i > 0) result.append(" ");
            StringBuilder reversed = new StringBuilder(words[i]);
            result.append(reversed.reverse());
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(reverseEachWord("hello club"));
    }
}