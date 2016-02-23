import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MajorityElement {

    public static void main(String... foobar) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 3, 3, 3, 0, 3, 3, 3};
        System.out.println(majorityElement(nums));
    }

    static int majorityElement(int[] nums) {
        if (nums.length == 0 || nums == null) return -1;
        Map<Integer, Integer> hm = new HashMap<>();
        int majorityElement = Integer.MIN_VALUE;
        for (int num : nums) {
            if (!hm.containsKey(num)) hm.put(num, 1);
            else {
                int valCount = hm.get(num);
                hm.put(num, ++valCount);
            }


            Set<Integer> keySet = hm.keySet();
            for (Integer key : keySet) {
                int val = hm.get(key);
                if (val > Math.floor(nums.length / 2)) {
                    majorityElement = key;
                    break;
                }
            }
        }
        return majorityElement;
    }
}