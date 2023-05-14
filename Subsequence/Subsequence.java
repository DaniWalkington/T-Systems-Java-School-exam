import java.util.List;

public class Subsequence {
    @SuppressWarnings("rawtypes")
    public boolean find(List x, List y) {
        if (x == null || y == null) {
            throw new InvalidArgumentException();
        }
        int ix = 0;
        int iy = 0;
        while (ix < x.size()) {
            if (x.size() - ix > y.size() - iy) {
                return false;
            }
            if (x.get(ix).equals(y.get(iy))) {
                ix++;
            }
            iy++;
        }
        return true;
    }
}
