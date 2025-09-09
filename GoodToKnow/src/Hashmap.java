import java.util.HashMap;

public class Hashmap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();

        map.put("Germany", "Berlin");
        map.put("USA", "Washington");
        map.put("Norway", "Oslo");
        map.put("England", "London");

        System.out.println(map);

        System.out.println(map.get("Germany"));

        map.remove("USA");
        System.out.println(map);

        System.out.println(map.size());

        for (String i : map.keySet()) {
            System.out.println(i);
        }
        for (String i : map.values()) {
            System.out.println(i);
        }
        for (String i : map.keySet()) {
            System.out.println("key: " + i + " value: " + map.get(i));
        }
        for (String i : map.keySet()) {
            System.out.println("key: " + i + " value: " + map.get(i));
        }
    }
}
