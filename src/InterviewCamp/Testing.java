package InterviewCamp;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Testing {

    public static void main(String[] args) {

        Map<String, String> asiaCapital1 = new HashMap<String, String>();
        asiaCapital1.put("Japan", "Tokyo");
        asiaCapital1.put("South Korea", "Seoul");

        Map<String, String> asiaCapital2 = new HashMap<String, String>();
        asiaCapital2.put("South Korea", "Seoul");
        asiaCapital2.put("Japan", "Tokyo");
        System.out.println(isEquals(asiaCapital1, asiaCapital2));

        List<String> str = new ArrayList<>();
        str.add("Stop");
        System.out.println(str.contains("Stop"));
        str.clear();


    }

    public static boolean isEquals(Map<String, String> asiaCapital1, Map<String, String> asiaCapital2) {
        return asiaCapital1.entrySet().stream().allMatch(e -> e.getValue().equals(asiaCapital2.get(e.getKey())));

    }

}
