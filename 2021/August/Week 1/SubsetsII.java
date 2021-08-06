import java.util.*;
public class SubsetsII {
    // August 3, 2021: Subsets II
    public static void combinationWithSingle_subSeq(int[] arr, int prev, boolean noCall, int idx, List<Integer> smallAns, List<List<Integer>> ans) {
        if(idx == arr.length) {
            List<Integer> base = new ArrayList<>(smallAns);
            ans.add(base);
            return;
        } 
        combinationWithSingle_subSeq(arr, arr[idx], true, idx + 1, smallAns, ans);
        if(noCall && prev == arr[idx]) return;
        smallAns.add(arr[idx]);
        combinationWithSingle_subSeq(arr, arr[idx], false, idx + 1, smallAns, ans);
        smallAns.remove(smallAns.size() - 1);
        
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> smallAns = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        combinationWithSingle_subSeq(nums, 0, false, 0, smallAns, ans);
        return ans;
    }
    
}
