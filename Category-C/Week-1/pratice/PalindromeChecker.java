public class PalindromeChecker {
    
    // Iterative approach
    public static boolean isPalindromeIterative(String text) {
        int left = 0, right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    // Recursive approach
    public static boolean isPalindromeRecursive(String text) {
        return isPalindromeRecHelper(text, 0, text.length() - 1);
    }
    
    private static boolean isPalindromeRecHelper(String text, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }
        return isPalindromeRecHelper(text, left + 1, right - 1);
    }
    
    // Array reversal approach
    public static boolean isPalindromeArrayReversal(String text) {
        char[] chars = text.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return text.equals(new String(chars));
    }
    
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter text to check: ");
        String text = sc.nextLine();
        
        boolean iterative = isPalindromeIterative(text);
        boolean recursive = isPalindromeRecursive(text);
        boolean arrayRev = isPalindromeArrayReversal(text);
        
        System.out.println("Iterative: " + (iterative ? "Palindrome" : "Not Palindrome"));
        System.out.println("Recursive: " + (recursive ? "Palindrome" : "Not Palindrome"));
        System.out.println("Array Reversal: " + (arrayRev ? "Palindrome" : "Not Palindrome"));
        
        sc.close();
    }
}