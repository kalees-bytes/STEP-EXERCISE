public class WarehouseInventoryBalancer {
    
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        // Calculate totals
        int totalA = 0, totalB = 0;
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            totalB += sectionB[i];
        }
        
        // Print status
        System.out.print("Section A Total: " + totalA + " | Section B Total: " + totalB);
        if (totalA == totalB) {
            System.out.print(" | Status: Balanced");
        } else {
            System.out.print(" | Status: Not Balanced");
        }
        System.out.println(" | Highest");
        
        // Find highest quantity
        int highest = sectionA[0];
        int section = 0, index = 0;
        
        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > highest) {
                highest = sectionA[i];
                section = 0;
                index = i;
            }
            if (sectionB[i] > highest) {
                highest = sectionB[i];
                section = 1;
                index = i;
            }
        }
        
        System.out.println("Quantity: " + highest + " (Section " + (section + 1) + ", Item " + (index + 1) + ")");
    }
    
    public static void main(String[] args) {
        int[] secA = {20, 15, 30};
        int[] secB = {25, 10, 30};
        analyzeInventory(secA, secB);
    }
}