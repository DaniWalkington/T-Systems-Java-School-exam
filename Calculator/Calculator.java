import java.util.*;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an expression: ");
        String expression = scanner.nextLine();
        double result = evaluateExpression(expression);
        System.out.printf("Result: %.4f\n", result);
    }

    public static double evaluateExpression(String expression) {
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == ' ') {
                continue;
            } else if (ch == '(') {
                operators.push(ch);
            } else if (Character.isDigit(ch)) {
                int j = i;
                while (j < expression.length() && (Character.isDigit(expression.charAt(j)) || expression.charAt(j) == '.')) {
                    j++;
                }
                double number = Double.parseDouble(expression.substring(i, j));
                numbers.push(number);
                i = j - 1;
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!operators.empty() && hasPrecedence(ch, operators.peek())) {
                    double b = numbers.pop();
                    double a = numbers.pop();
                    char operator = operators.pop();
                    double result = performOperation(a, b, operator);
                    numbers.push(result);
                }
                operators.push(ch);
            } else if (ch == ')') {
                while (!operators.empty() && operators.peek() != '(') {
                    double b = numbers.pop();
                    double a = numbers.pop();
                    char operator = operators.pop();
                    double result = performOperation(a, b, operator);
                    numbers.push(result);
                }
                operators.pop();
            }
        }

        while (!operators.empty()) {
            double b = numbers.pop();
            double a = numbers.pop();
            char operator = operators.pop();
            double result = performOperation(a, b, operator);
            numbers.push(result);
        }

        return Math.round(numbers.pop() * 10000) / 10000.0;
    }

    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false;
        }
        return true;
    }

    public static double performOperation(double a, double b, char operator) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }
        throw new IllegalArgumentException("Unknown operator: " + operator);
    }
}
