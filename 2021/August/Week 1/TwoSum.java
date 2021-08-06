import java.util.HashMap;
public class TwoSum {
    // August 2, 2021: Two Sum
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i = 0; i < nums.length; i++) m.put(nums[i], i);
        int[] ans = new int[2];
        for(int i = 0; i < nums.length; i++) {
            if(m.containsKey(target - nums[i]) && m.get(target - nums[i]) != i) {
                ans[0] = i;
                ans[1] = m.get(target - nums[i]);
                break;
            }
        }
        return ans;
    }
    
}
