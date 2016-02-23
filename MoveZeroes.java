public class MoveZeroes {

    public static void main(String... args) {
        int[] nums = {0,0,1};
        moveZeroes(nums);
        // print out the array
        for(int i : nums) System.out.print(i + " ");
    }

    static void moveZeroes(int[] nums) {
        if(nums.length == 0 || nums == null) return;
        int count = 0;
        for(int i = 0; i < nums.length; ++i ){
            if ( nums[i] == 0 ){
                count++; // count the number of zeroes
            }else{
                nums[i-count] = nums[i]; // move the non-zero integer
            }
        }
        // set the trailing zeros
        for( int i = 0; i < count; ++i ){
            nums[nums.length-1-i] = 0;
        }
    }

}
