import java.util.Scanner;

// Main class for Quantity Measurement Application
public class QuantityMeasurementApp {

    // Inner class for Feet measurement
    static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Feet other = (Feet) obj;
            return Double.compare(this.value, other.value) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    // Inner class for Inches measurement
    static class Inches {
        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Inches other = (Inches) obj;
            return Double.compare(this.value, other.value) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    // Utility method to check numeric input
    public static boolean isNumeric(String input) {
        if (input == null) return false;
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Static method to check Feet equality
    public static boolean compareFeet(String val1, String val2) {
        if (!isNumeric(val1) || !isNumeric(val2)) return false;
        Feet f1 = new Feet(Double.parseDouble(val1));
        Feet f2 = new Feet(Double.parseDouble(val2));
        return f1.equals(f2);
    }

    // Static method to check Inches equality
    public static boolean compareInches(String val1, String val2) {
        if (!isNumeric(val1) || !isNumeric(val2)) return false;
        Inches i1 = new Inches(Double.parseDouble(val1));
        Inches i2 = new Inches(Double.parseDouble(val2));
        return i1.equals(i2);
    }

    // Main method
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter inch 1 :");
        String inch1 = input.nextLine();
        System.out.print("Enter inch 2 :");
        String inch2 = input.nextLine();
        System.out.print("Enter Feet 1 :");
        String feet1 = input.nextLine();
        System.out.print("Enter Feet 2 :");
        String feet2 = input.nextLine();

        // Inches comparison
        boolean inchResult = compareInches(inch1, inch2);
        System.out.println("Input: " + inch1 + " inch and " + inch2 + " inch");
        System.out.println("Output: Equal (" + inchResult + ")");

        // Feet comparison
        boolean feetResult = compareFeet(feet1, feet2);
        System.out.println("Input: " + feet1 + " ft and " + feet2 + " ft");
        System.out.println("Output: Equal (" + feetResult + ")");
    }
}