public class TypingAccuracyChecker {
    
    public static void checkTypingAccuracy(String original, String typed) {
        int total = original.length();
        int matched = 0;
        int firstMismatchPos = -1;
        
        for (int i = 0; i < total; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatchPos == -1) {
                firstMismatchPos = i + 1; // position is 1-based
            }
        }
        
        double accuracy = (double) matched / total * 100;
        
        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%", matched, total, accuracy);
        
        if (firstMismatchPos == -1) {
            System.out.print(" | No Mismatches");
        } else {
            int len = original.length();
            char origChar = original.charAt(firstMismatchPos - 1);
            char typedChar = typed.charAt(firstMismatchPos - 1);
            System.out.printf(" | First Mismatch at position %d ('%c' vs '%c')", firstMismatchPos, origChar, typedChar);
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}