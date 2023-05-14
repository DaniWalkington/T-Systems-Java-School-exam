import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PyramidBuilder {

    public int[][] buildPyramid(List<Integer> inputNumbers) throws CannotBuildPyramidException {
        int n = inputNumbers.size();

        // Calculate the height of the pyramid
        int height = 0;
        for (int i = 1; i <= n; i += height) {
            height++;
            if (i + height > n + 1) {
                throw new CannotBuildPyramidException("Cannot build pyramid with given input");
            }
        }

        Collections.sort(inputNumbers);

        
        int[][] pyramid = new int[height][2 * height - 1];

        int index = 0;
        for (int i = 0; i < height; i++) {
            int j = height - i - 1;
            for (int k = 0; k <= i; k++) {
                pyramid[i][j] = inputNumbers.get(index);
                index++;
                j += 2;
            }
        }

        return pyramid;
    }
    public static class CannotBuildPyramidException extends RuntimeException {
        public CannotBuildPyramidException(String message) {
            super(message);
        }
    }
}
