package InterviewCamp.lineSweepTimeInterval;

import java.util.Collection;

public class Point implements Comparable<Point> {
    int time;
    boolean isStart;

    public Point(int time, boolean isStart) {
        super();
        this.time = time;
        this.isStart = isStart;
    }

    public int getTime() {
        return time;
    }

    public boolean isStart() {
        return isStart;
    }

    @Override
    public int compareTo(Point other) {

        if (time == other.getTime()) {
            if (isStart == other.isStart()) {
                return 0;
            } else {
                return isStart ? -1 : 1;
            }
        }
        return time > other.getTime() ? 1 : -1;
    }
}
