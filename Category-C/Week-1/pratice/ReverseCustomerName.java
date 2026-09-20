public class ReverseCustomerName {
    
    public static String reverseCustomerName(String customerName) {
        StringBuilder sb = new StringBuilder(customerName);
        return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter customer name: ");
        String original = sc.nextLine();
        
        String reversed = reverseCustomerName(original);
        System.out.println("Original Name: " + original);
        System.out.println("Reversed Name: " + reversed);
        
        sc.close();
    }
}