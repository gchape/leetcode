// Last updated: 8/23/2026, 9:38:50 AM
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
18    public boolean isValidBST(TreeNode root) {
19        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
20    }
21
22    private boolean isValidBST(TreeNode root, long lower, long upper) {
23        if (root == null) {
24            return true;
25        }
26
27        if (root.val <= lower || root.val >= upper) {
28            return false;
29        }
30
31        return isValidBST(root.left, lower, root.val)
32                && isValidBST(root.right, root.val, upper);
33    }
34}