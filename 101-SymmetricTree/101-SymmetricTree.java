// Last updated: 8/22/2026, 7:30:08 PM
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
19        if (root.left == null && root.right == null) {
20            return true;
21        }
22
23        return isSymmetric(root.left, root.right);
24    }
25
26    public boolean isSymmetric(TreeNode left, TreeNode right) {
27        if (left == null && right != null) return false;
28        if (left != null && right == null) return false;
29
30        if (left == null && right == null) return true;
31
32        return left.val == right.val &&
33                isSymmetric(left.right, right.left) &&
34                isSymmetric(left.left, right.right);
35    }
36}