import java.awt.*;
import java.util.HashSet;

public class QueensAttackII {
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        HashSet<Point> obstacleCells = new HashSet<Point>();
        for (int i = 0; i < obstacles.length; i++) {
            obstacleCells.add(new Point(obstacles[i][0], obstacles[i][1]));
        }

        int result = 0;
        Point p;
        for (Direction direction : Direction.values()) {
            p = new Point(r_q, c_q);
            direction.shift(p);
            while (isOnBoard(n, p) && !obstacleCells.contains(p)) {
                result++;
                direction.shift(p);
            }
        }
        return result;
    }

    private static boolean isOnBoard(int n, Point c) {
        if (c.x <= 0 || c.x > n || c.y <= 0 || c.y > n) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        int r_q = 4;
        int c_q = 3;
        int[][] obstacles = {{5, 5}, {4, 2}, {2, 3}};
        System.out.println(queensAttack(n, k, r_q, c_q, obstacles));
    }
}

enum Direction {
    UP (1, 0),
    UP_RIGHT (1, 1),
    RIGHT (0, 1),
    DOWN_RIGHT (-1, 1),
    DOWN (-1,   0),
    DOWN_LEFT (-1, -1),
    LEFT (0, -1),
    UP_LEFT (1, -1);

    private final int xShift;
    private final int yShift;

    Direction(int xShift, int yShift) {
        this.xShift = xShift;
        this.yShift = yShift;
    }

    public void shift(Point p) {
        p.x += xShift;
        p.y += yShift;
    }
}
