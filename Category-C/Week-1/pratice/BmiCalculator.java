public class BmiCalculator {
    
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 24.9) return "Normal";
        else if (bmi < 29.9) return "Overweight";
        else return "Obese";
    }
    
    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("\nWellness Report Table:");
        System.out.println("Person | Height (m) | Weight (kg) | BMI   | Status");
        System.out.println("-------|------------|-------------|-------|----------");
        
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);
            System.out.printf("  %d    |    %.2f    |    %.1f    | %.2f | %s%n",
                            i + 1, heights[i], weights[i], bmi, status);
        }
    }
    
    public static double[] calculateBmis(double[] heights, double[] weights) {
        double[] bmis = new double[heights.length];
        for (int i = 0; i < heights.length; i++) {
            bmis[i] = weights[i] / (heights[i] * heights[i]);
        }
        return bmis;
    }
    
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        java.util.Random rand = new java.util.Random();
        
        System.out.print("Enter number of people: ");
        int n = sc.nextInt();
        
        double[] heights = new double[n];
        double[] weights = new double[n];
        
        // Generate random data for demo
        for (int i = 0; i < n; i++) {
            heights[i] = 1.5 + rand.nextDouble() * 0.7;  // 1.5m to 2.2m
            weights[i] = 50 + rand.nextDouble() * 60;    // 50kg to 110kg
        }
        
        printWellnessReport(heights, weights);
        sc.close();
    }
}