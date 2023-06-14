package InterviewCamp.lineSweepTimeInterval;

public class PointBuilding implements Comparable<PointBuilding> {
    int height;
    int location;
    boolean isStart;

    public PointBuilding(int height,  int location, boolean isStart) {
        super();
        this.height = height;
        this.location = location;
        this.isStart = isStart;
    }

    public int getHeight() {
        return height;
    }

    public int getLocation() {
        return location;
    }

    public boolean isStart() {
        return isStart;
    }

    @Override
    public int compareTo(PointBuilding other) {

     if (location == other.getLocation()) {
         return isStart ? -1 : 1;
     }
     return location > other.location ? 1 : -1;
    }
}
