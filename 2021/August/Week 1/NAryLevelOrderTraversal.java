import java.util.*;
public class NAryLevelOrderTraversal {
    // August 6, 2021: N-ary Tree Level Order Traversal
    
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    
    public List<List<Integer>> levelOrder(Node root) {
        LinkedList<Node> que = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        que.add(root);
        while(que.size() != 0){
            int size = que.size();
            List<Integer> smallAns = new ArrayList<>();
            while(size-- > 0) {
                Node curr = que.remove();
                smallAns.add(curr.val);
                for(Node child: curr.children) que.add(child);
            }
            ans.add(smallAns);
        }
        return ans;
    }
}