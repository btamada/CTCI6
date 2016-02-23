
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,5,3,5};
        System.out.println(removeElement(nums,5));
    }

    static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int n : nums)
            if (n != val)
                nums[i++] = n;
        return i;
    }
}
