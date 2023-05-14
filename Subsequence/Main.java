import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter elements of list x, separated by commas:");
        String[] xInput = sc.nextLine().split(",");
        List<String> x = new ArrayList<>();
        for (String s : xInput) {
            x.add(s.trim());
        }

        System.out.println("Enter elements of list y, separated by commas:");
        String[] yInput = sc.nextLine().split(",");
        List<String> y = new ArrayList<>();
        for (String s : yInput) {
            y.add(s.trim());
        }

        Subsequence subsequence = new Subsequence();
        boolean result = subsequence.find(x, y);

        System.out.println("Can list x be obtained from list y by removing elements? " + result);
    }
}
