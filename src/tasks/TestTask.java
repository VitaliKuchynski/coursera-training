package tasks;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by vitalikuchynski on 5/15/18.
 */
public class TestTask {


    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        Map<Integer, String> map2 = null;

        map.put(1, "one");
        map.put(2, "Second");
        map.put(3, null);
        map.put(4, "forth");
        map.put(5, "fife");
        map.put(6, "Second");
        map.put(7, null);
        map.put(8, "Second");


        System.out.println(getList(map2, "Second"));
    }


public static List<String> getList(Map<Integer, String> map, String word) {

        if (!map.isEmpty() || map == null) {
        return  map.values().stream().flatMap(Stream::ofNullable).filter(line -> line.contains(word)).collect(Collectors.toList());
    } else {
            throw new IllegalArgumentException("Map is empty");
        }


}




}
