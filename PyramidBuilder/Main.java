import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PyramidBuilder pyramidBuilder = new PyramidBuilder();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the comma-separated list of integers: ");
        String inputString = scanner.nextLine();
        String[] inputArray = inputString.split(",");
        List<Integer> inputList = new ArrayList<>();
        for (String str : inputArray) {
            inputList.add(Integer.parseInt(str.trim()));
        }

        int size = inputList.size();
        int n = (int) Math.ceil((Math.sqrt(1 + 8 * size) - 1) / 2);
        int numToAdd = n * (n + 1) / 2 - size;
        for (int i = 0; i < numToAdd; i++) {
            inputList.add(0);
        }
        int[][] pyramid = pyramidBuilder.buildPyramid(inputList);
        printPyramid(pyramid);
    }

    private static void printPyramid(int[][] pyramid) {
        for (int[] row : pyramid) {
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
