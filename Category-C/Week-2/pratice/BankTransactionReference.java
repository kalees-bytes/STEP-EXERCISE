public class BankTransactionReference {
    
    public static String normalizeReference(String raw) {
        return raw.trim().toUpperCase();
    }
    
    public static String validateAndFormat(String reference) {
        String normalized = normalizeReference(reference);
        
        // Check length
        if (normalized.length() != 14) {
            return "Invalid: wrong length";
        }
        
        // Check bank code (first 3 letters)
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(normalized.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }
        
        // Check body (remaining 11 digits)
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(normalized.charAt(i))) {
                return "Invalid: body must be all digits";
            }
        }
        
        // Build formatted output
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(normalized.substring(0, 3));
        sb.append("] DATE: ");
        sb.append(normalized.substring(3, 5)).append("/");
        sb.append(normalized.substring(5, 7)).append("/");
        sb.append(normalized.substring(7, 9));
        sb.append(" | SEQ: ");
        sb.append(normalized.substring(9, 14));
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(validateAndFormat(" hdf03022600042 "));
        System.out.println(validateAndFormat("12F03022600042"));
    }
}