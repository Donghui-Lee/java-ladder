package game.ladder.domain;

/**
 * Created by yusik on 2019/11/10.
 */
public class Point {

    private boolean movable;

    private Point(boolean movable) {
        this.movable = movable;
    }

    public static Point of(boolean movable) {
        return new Point(movable);
    }

    public boolean movable() {
        return movable;
    }

    public Point createNextPoint(LadderStrategy ladderStrategy) {
        return movable() ? Point.of(false) : Point.of(ladderStrategy.movable());
    }

    @Override
    public String toString() {
        return String.valueOf(movable);
    }
}