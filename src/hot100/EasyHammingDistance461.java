package hot100;

public class EasyHammingDistance461 {
    public int hammingDistance(int x, int y) {
        int res = 0;
        int x1 = x % 2, x2 = x / 2;
        int y1 = y % 2, y2 = y / 2;
        while (x2 != 0 || y2 != 0 || x1 != 0 || y1 != 0) {
            if(x1 != y1)
                res++;
            x1 = x2 % 2;
            x2 = x2 / 2;
            y1 = y2 % 2;
            y2 = y2 / 2;
        }
        return res;
    }
}
