import java.util.Scanner;
public class QuantityMeasurementApp {

    // Inner class representing Feet measurement
    static class Feet {
        // Private final field for immutability
        private final double value;

        // Constructor to initialize value
        public Feet(double value) {
            this.value = value;
        }

        // Getter method (optional but useful)
        public double getValue() {
            return value;
        }

        // Override equals method for value-based comparison
        @Override
        public boolean equals(Object obj) {
            // Reflexive check
            if (this == obj) {
                return true;
            }
            // Null and type check
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            // Cast safely
            Feet other = (Feet) obj;
            // Compare using Double.compare
            return Double.compare(this.value, other.value) == 0;
        }

        // Override hashCode (good practice with equals)
        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    // Method to validate numeric input
    public static boolean isNumeric(String input) {
        if (input == null) {
            return false;
        }
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter value 1:");
        String input1 = input.nextLine();
        System.out.print("Enter value 2:");
        String input2 = input.nextLine();

        // Validate inputs
        if (!isNumeric(input1) || !isNumeric(input2)) {
            System.out.println("Invalid input. Please enter numeric values.");
            return;
        }

        // Create Feet objects
        Feet feet1 = new Feet(Double.parseDouble(input1));
        Feet feet2 = new Feet(Double.parseDouble(input2));

        // Compare values
        boolean result = feet1.equals(feet2);

        // Output result
        System.out.println("Output: is_Equal (" + result + ")");
    }
}