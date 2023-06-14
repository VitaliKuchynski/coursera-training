package InterviewCamp.lineSweepTimeInterval;

import java.util.*;

// Level: Hard
// You are given a list of buildings that are part of a skyline.
// For each building, you are given the height, start and end points.
public class Skyline {

    public static void drawSkyline(Building [] buildings) {

        List<PointBuilding> points = new ArrayList<>();

        for (Building building: buildings) {
            points.add(new PointBuilding(building.getHeight(), building.getStart(), true));
            points.add(new PointBuilding(building.getHeight(), building.getEnd(), false));
        }

        Collections.sort(points);

        BuildingMap map = new BuildingMap();
        int currenMax = 0;
        int currentMAxStartX = 0;

        for (int i = 0; i < points.size(); i++) {
            PointBuilding point = points.get(i);

            if (point.isStart()) {
                map.put(point.getHeight());
                if (point.getHeight() > currenMax) {
                    // drawHorizontal(currentMax, currentMaxStartX, point.getLocation());
                    // drawVertical(point.getLocation(), currentMax, point.getHeight());
                    currenMax = point.getHeight();
                    currentMAxStartX = point.getLocation();
                }
            }  else {
                map.remove(point.getHeight());
                if (currenMax == point.getHeight()) {
                    // drawHorizontal(currentMax, currentMaxStartX, point.getLocation());
                    int oldMax = currenMax;
                    currentMAxStartX = point.getLocation();
                    // drawVertical(point.getLocation(), currentMax, point.getHeight());
                }
            }
        }
    }
}

/* * This is the Hash Table implementation of BuildingMap.
* * Time Complexity: O(1) for insertion, O(N) for max lookup.
* */

class BuildingMap {

    Map<Integer, Integer> map;

    public BuildingMap() {
        this.map = new HashMap<>();
    }

    public void put(int height) {
        if (map.containsKey(height)) {
            map.put(height, map.get(height) + 1);
        } else {
            map.put(height, 1);
        }
    }

    public void remove(int height) {
        if (!map.containsKey(height)) {
            return;
        }
        map.put(height, map.get(height) - 1);
        if (map.get(height) <= 0) {
            map.remove(height);
        }
    }

    public int getMax() {
        int max = 0;
        for (Integer key: map.keySet()) {
            if (key > max);
            max = key;
        }
        return max;
    }
}

