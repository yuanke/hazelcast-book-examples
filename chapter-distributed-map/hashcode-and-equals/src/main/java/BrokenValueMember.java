import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.util.HashMap;
import java.util.Map;

public class BrokenValueMember {
    public static void main(String[] args) {
        HazelcastInstance hz = Hazelcast.newHazelcastInstance();

        Map<String, Pair> normalMap = new HashMap<String,Pair>();
        Map<String, Pair> binaryMap = hz.getMap("binaryMap");
        Map<String, Pair> objectMap = hz.getMap("objectMap");
        Map<String, Pair> cachedMap = hz.getMap("cachedMap");

        Pair v1 = new Pair("a", "1");
        Pair v2 = new Pair("a", "2");

        normalMap.put("key", v1);
        binaryMap.put("key", v1);
        objectMap.put("key", v1);
        cachedMap.put("key", v1);

        System.out.println("normalMap.contains:" + normalMap.containsValue(v2));
        System.out.println("binaryMap.contains:" + binaryMap.containsValue(v2));
        System.out.println("objectMap.contains:" + objectMap.containsValue(v2));
        System.out.println("cachedMap.contains:" + cachedMap.containsValue(v2));
        System.exit(0);
    }
}
