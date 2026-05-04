package org.example;

public class Calculator {
    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }

    public double modulus(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Modulus by zero is not allowed.");
        }
        return a % b;
    }

    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public double sqrt(double a) {
        if (a < 0) {
            throw new ArithmeticException("Square root of a negative number is not defined.");
        }
        return Math.sqrt(a);
    }

    static void main() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        Calculator calc = new Calculator();

        System.out.println("==============================");
        System.out.println("   Simple Terminal Calculator ");
        System.out.println("==============================");
        System.out.println("Operations: +  -  *  /  %  ^  sqrt");
        System.out.println("Type 'exit' to quit.\n");

        while (true) {
            System.out.print("Enter expression (e.g. 5 + 3) or 'sqrt 16': ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            try {
                String[] parts = input.split("\\s+");

                if (parts.length == 2 && parts[0].equalsIgnoreCase("sqrt")) {
                    double a = Double.parseDouble(parts[1]);
                    System.out.println("Result: " + calc.sqrt(a));
                } else if (parts.length == 3) {
                    double a = Double.parseDouble(parts[0]);
                    String op = parts[1];
                    double b = Double.parseDouble(parts[2]);

                    double result;
                    switch (op) {
                        case "+": result = calc.add(a, b); break;
                        case "-": result = calc.subtract(a, b); break;
                        case "*": result = calc.multiply(a, b); break;
                        case "/": result = calc.divide(a, b); break;
                        case "%": result = calc.modulus(a, b); break;
                        case "^": result = calc.power(a, b); break;
                        default:
                            System.out.println("Unknown operator: " + op);
                            continue;
                    }
                    System.out.println("Result: " + result);
                } else {
                    System.out.println("Invalid input. Try: 5 + 3  or  sqrt 9");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid number format.");
            } catch (ArithmeticException e) {
                System.out.println("Math Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
