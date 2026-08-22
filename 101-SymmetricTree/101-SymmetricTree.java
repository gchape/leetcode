// Last updated: 8/22/2026, 7:30:49 PM
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
18    public boolean isSymmetric(TreeNode root) {
19        return isSymmetric(root.left, root.right);
20    }
21
22    private boolean isSymmetric(TreeNode left, TreeNode right) {
23        if (left == null || right == null) {
24            return left == right;
25        }
26
27        return left.val == right.val &&
28                isSymmetric(left.left, right.right) &&
29                isSymmetric(left.right, right.left);
30    }
31}