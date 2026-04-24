import java.util.Scanner;

// Main class for Quantity Measurement Application
public class QuantityMeasurementApp {

    // Enum for Length Units with conversion factor to base unit (feet)
    enum LengthUnit {
        FEET(1.0),
        INCH(1.0 / 12.0);

        private final double toFeetFactor;

        LengthUnit(double toFeetFactor) {
            this.toFeetFactor = toFeetFactor;
        }

        // Convert value to feet
        public double toFeet(double value) {
            return value * toFeetFactor;
        }

        // Convert string to enum safely
        public static LengthUnit fromString(String unit) {
            if (unit == null) return null;
            switch (unit.toLowerCase()) {
                case "feet":
                case "foot":
                case "ft":
                    return FEET;
                case "inch":
                case "inches":
                case "in":
                    return INCH;
                default:
                    return null;
            }
        }
    }

    // Generic Quantity class
    static class Quantity {
        private final double value;
        private final LengthUnit unit;

        public Quantity(double value, LengthUnit unit) {
            if (unit == null) {
                throw new IllegalArgumentException("Unit cannot be null");
            }
            this.value = value;
            this.unit = unit;
        }

        public double toFeet() {
            return unit.toFeet(value);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Quantity other = (Quantity) obj;
            return Double.compare(this.toFeet(), other.toFeet()) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(toFeet());
        }
    }

    // Check numeric input
    public static boolean isNumeric(String input) {
        if (input == null) return false;
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Method to take one quantity input cleanly
    public static Quantity getQuantityInput(Scanner scanner, String label) {
        while (true) {
            System.out.println("\nEnter " + label + " measurement (Example: 1.5 feet OR 12 inch):");
            System.out.print("Enter value: ");
            String valueInput = scanner.nextLine();

            System.out.print("Enter unit (feet/ft/inch/in): ");
            String unitInput = scanner.nextLine();

            // Validate number
            if (!isNumeric(valueInput)) {
                System.out.println("Invalid value! Please enter a numeric value.");
                continue;
            }

            // Validate unit
            LengthUnit unit = LengthUnit.fromString(unitInput);
            if (unit == null) {
                System.out.println("Invalid unit! Allowed: feet, ft, inch, in");
                continue;
            }

            // Return valid quantity
            return new Quantity(Double.parseDouble(valueInput), unit);
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Quantity Measurement Equality Checker =====");
        System.out.println("You can compare values like: 1 feet and 12 inches");

        // Take inputs
        Quantity q1 = getQuantityInput(scanner, "FIRST");
        Quantity q2 = getQuantityInput(scanner, "SECOND");

        // Compare
        boolean result = q1.equals(q2);

        // Output
        System.out.println("\n===== RESULT =====");
        System.out.println("Are both quantities equal? ➜ " + result);

        scanner.close();
    }
}