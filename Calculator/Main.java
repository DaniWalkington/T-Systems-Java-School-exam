import java.util.Scanner;
import javax.script.ScriptEngineManager;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter expression to evaluate or type 'exit' to quit: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            String result = String.valueOf(calculator.evaluateExpression(input));
            if (result == null) {
                System.out.println("Invalid input format");
            } else {
                System.out.println(result);
            }
        }
    }
}
