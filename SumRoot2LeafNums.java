// Approach: Traverse the tree in a DFS manner, using a path (ArrayList) to store the current path in each recursive call. When a leaf
// node is encountered, compute the number formed using the current path and add it to the global sum. After traversing the non-null
// children, backtrack** by removing the current element from the path.
// Time Complexity: O(n^2) where n - node count
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// https://leetcode.com/problems/sum-root-to-leaf-numbers/description/

import java.util.List;
import java.util.ArrayList;

public class SumRoot2LeafNums {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) {
            val = v;
        }
    }
    private int sum;

    int sumRoot2Leaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> path = new ArrayList<>();
        sum = 0;
        traverse(root, path);
        return sum;
    }

    void traverse(TreeNode root, List<Integer> path) {
        if (root.left == null && root.right == null) {
            int s = 0;
            for (int i = 0; i < path.size(); i++) {
                s = s * 10 + path.get(i);
            }
            s = s * 10 + root.val;
            sum += s;
            return;
        }
        path.add(root.val);
        if (root.left != null) {
            traverse(root.left, path);
        }
        if (root.right != null) {
            traverse(root.right, path);
        }
        path.remove(path.size() - 1); // backtrack**
    }

    public static void main(String[] args) {
        SumRoot2LeafNums sumr2l = new SumRoot2LeafNums();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(1);
        System.out.println("Sum of root to leaf numbers: " + sumr2l.sumRoot2Leaf(root));
    }
}