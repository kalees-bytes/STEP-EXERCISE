import java.util.*;

public class LibraryISBNNormalizer {
    
    public static String normalizeCode(String raw) {
        String trimmed = raw.trim();
        String pubCode = trimmed.substring(0, Math.min(3, trimmed.length())).toUpperCase();
        String rest = trimmed.length() > 3 ? trimmed.substring(3) : "";
        return pubCode + rest;
    }
    
    public static String validateAndFormat(String code) {
        String normalized = normalizeCode(code);
        
        // Trim first to get actual code
        String normalizedTrimmed = normalized.trim();
        
        // Check length
        if (normalizedTrimmed.length() != 13) {
            return "Invalid: wrong length";
        }
        
        // Check publisher code (first 3 letters)
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(normalizedTrimmed.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }
        
        // Check body (remaining 10: 4 digits + 6 digits)
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(normalizedTrimmed.charAt(i))) {
                return "Invalid: body must be all digits";
            }
        }
        
        // Build formatted output
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(normalizedTrimmed.substring(0, 3));
        sb.append("] YEAR: 20");
        sb.append(normalizedTrimmed.substring(4, 6));
        sb.append(" | CATALOG: ");
        sb.append(normalizedTrimmed.substring(6, 12));
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(validateAndFormat(" pen2026004251 "));
        System.out.println(validateAndFormat("12N2026004251"));
    }
}