import java.util.*;
public class PathSumII {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    // August 4, 2021: Path Sum II
    public static void pathSumHelper(TreeNode root, int target, List<Integer> smallAns, List<List<Integer>> ans) {
        if(root == null) return;
        if(root.left == null && root.right == null && target - root.val == 0) {
            List<Integer> base = new ArrayList<>(smallAns);
            base.add(root.val);
            ans.add(base);
            return;
        }
        
        smallAns.add(root.val);
        pathSumHelper(root.left, target - root.val, smallAns, ans);
        pathSumHelper(root.right, target - root.val, smallAns, ans);
        smallAns.remove(smallAns.size() - 1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> smallAns = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        pathSumHelper(root, targetSum, smallAns, ans);
        return ans;
        
    }
    
}
