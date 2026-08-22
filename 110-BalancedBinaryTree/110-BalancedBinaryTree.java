// Last updated: 8/22/2026, 7:13:41 PM
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
18    public boolean isBalanced(TreeNode root) {
19        return height(root) != -1;
20    }
21
22    private int height(TreeNode root) {
23        if (root == null) {
24            return 0;
25        }
26
27        int leftHeight = height(root.left);
28        if (leftHeight == -1) return -1;
29
30        int rightHeight = height(root.right);
31        if (rightHeight == -1) return -1;
32
33        if (Math.abs(leftHeight - rightHeight) > 1) {
34            return -1;
35        }
36
37        return Math.max(leftHeight, rightHeight) + 1;
38    }
39}