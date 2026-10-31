import java.util.Scanner;

// Custom Exception
class DivideByZeroException extends Exception {

    DivideByZeroException(String message) {
        super(message);
    }
}

public class GuardedCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean success = false;

        while (!success) {

            try {

                System.out.print("Enter first number: ");
                double num1 = Double.parseDouble(sc.next());

                System.out.print("Enter operator (+, -, *, /): ");
                char op = sc.next().charAt(0);

                System.out.print("Enter second number: ");
                double num2 = Double.parseDouble(sc.next());

                double result = 0;

                switch (op) {

                    case '+':
                        result = num1 + num2;
                        break;

                    case '-':
                        result = num1 - num2;
                        break;

                    case '*':
                        result = num1 * num2;
                        break;

                    case '/':
                        if (num2 == 0) {
                            throw new DivideByZeroException(
                                "Cannot divide by zero!"
                            );
                        }
                        result = num1 / num2;
                        break;

                    default:
                        throw new IllegalArgumentException(
                            "Invalid operator!"
                        );
                }

                System.out.println("Result = " + result);

                success = true;

            }

            catch (NumberFormatException e) {

                System.out.println("Error: Please enter valid numbers.");

            }

            catch (DivideByZeroException e) {

                System.out.println("Error: " + e.getMessage());

            }

            catch (IllegalArgumentException e) {

                System.out.println("Error: " + e.getMessage());

            }

            finally {

                System.out.println("Calculation attempt logged.");
                System.out.println("---------------------------");

            }
        }

        System.out.println("Calculator completed.");

        sc.close();
    }
}