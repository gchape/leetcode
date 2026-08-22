// Last updated: 8/22/2026, 8:17:03 PM
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17
18    public boolean hasPathSum(TreeNode root, int targetSum) {
19        return hasPathSumHelper(root, 0, targetSum);
20    }
21
22    public boolean hasPathSumHelper(TreeNode root, int currentSum, int targetSum) {
23        if (root == null) {
24            return false;
25        }
26
27        currentSum += root.val; 
28
29        if (isLeaf(root) && currentSum == targetSum) {
30            return true;
31        }
32
33        return hasPathSumHelper(root.left, currentSum, targetSum) || 
34                hasPathSumHelper(root.right, currentSum, targetSum);
35    }
36
37    private boolean isLeaf(TreeNode root) {
38        return root.left == null && root.right == null;
39    }
40}