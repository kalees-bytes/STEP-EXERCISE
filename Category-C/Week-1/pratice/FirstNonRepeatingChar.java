import java.util.*;

public class FirstNonRepeatingChar {
    
    public static char FirstNonRepeatingChar(String text) {
        Map<Character, Integer> freq = new HashMap<>();
        
        // Count frequency
        for (char c : text.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        
        // Find first with freq = 1
        for (char c : text.toCharArray()) {
            if (freq.get(c) == 1) {
                return c;
            }
        }
        
        throw new RuntimeException("No Non-Repeating Character Found");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        
        try {
            char result = FirstNonRepeatingChar(text);
            System.out.println("First Non-Repeating Character: '" + result + "'");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        
        sc.close();
    }
}