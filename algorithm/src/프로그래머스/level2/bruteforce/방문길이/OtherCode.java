package 프로그래머스.level2.bruteforce.방문길이;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class OtherCode {
    public static void main(String[] args) {
        String dirs = "UD";
        Set<Road> visited = new HashSet<>();
        Road initRoad = new Road();
        for (char command : dirs.toCharArray()) {
            RoadMover.valueOf(String.valueOf(command)).command(initRoad.getStart())
                    .ifPresent(road -> {
                        initRoad.setStart(road.getEnd());
                        visited.add(road);
                    });
        }
    }
}
enum RoadMover implements RoadMoveStrategy {

    U(p -> Optional.ofNullable(Road.of(p, new Point(p.getY() - 1, p.getX())))),
    D(p -> Optional.ofNullable(Road.of(p, new Point(p.getY() + 1, p.getX())))),
    L(p -> Optional.ofNullable(Road.of(p, new Point(p.getY(), p.getX() - 1)))),
    R(p -> Optional.ofNullable(Road.of(p, new Point(p.getY(), p.getX() + 1))));

    public final RoadMoveStrategy robotCommand;

    RoadMover(RoadMoveStrategy robotCommand) {
        this.robotCommand = robotCommand;
    }

    @Override
    public Optional<Road> command(Point p) {
        return robotCommand.command(p);
    }

}

@FunctionalInterface
interface RoadMoveStrategy {

    Optional<Road> command(Point p);
}

class Road {
    private Point start;
    private Point end;

    private Road(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Road() {
        this.start = new Point(0, 0);
    }

    public static Road of(Point start, Point end) {
        return end.isSafe() ? new Road(start, end) : null;
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Road road = (Road) o;
        return start.equals(road.end) && end.equals(road.start) || start.equals(road.start) && end.equals(road.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start.hashCode() * end.hashCode());
    }

    public void setStart(Point end) {
        this.start = end;
    }

}

class Point {

    private final int y;
    private final int x;

    private static final int MAX_BOUND = 5;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public boolean isSafe() {
        return Math.abs(y) <= MAX_BOUND && Math.abs(x) <= MAX_BOUND;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return y == point.y && x == point.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(y + x);
    }

}
