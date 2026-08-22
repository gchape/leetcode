// Last updated: 8/22/2026, 7:12:32 PM
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
18    private boolean isBalanced = true;
19
20    public boolean isBalanced(TreeNode root) {
21        isBalancedHelper(root);
22
23        return isBalanced;
24    }
25
26    private int isBalancedHelper(TreeNode root) {
27        if (root == null) return 0;
28
29        int leftHeight = isBalancedHelper(root.left) + 1;
30        int rightHeght = isBalancedHelper(root.right) + 1;
31
32        if (Math.abs(leftHeight - rightHeght) > 1) {
33            isBalanced = false;
34        }
35
36        return Math.max(leftHeight, rightHeght);
37    }
38}