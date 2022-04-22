package com.sthatiko.adhoc;

import java.util.Map;
import java.util.TreeMap;

public class BlaBla {
    public static void main(String[] args) {
        Map<String, String> map = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        map.put("ADBBKUP", "bla");
        map.put("ADBBKUp", "bla1");
        map.put("ADBBKUp", "bla2");

        System.out.println(map.get("adbbkup"));
    }
}
