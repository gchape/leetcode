// Last updated: 8/22/2026, 9:13:57 PM
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
18    public int sumNumbers(TreeNode root) {
19        return sumNumbers(root, 0);
20    }
21
22    public int sumNumbers(TreeNode root, int currentSum) {
23        if (root == null) {
24            return 0;
25        }
26
27        if (isLeaf(root)) {
28            return currentSum + root.val;
29        }
30
31        currentSum = (currentSum + root.val) * 10;
32
33        return sumNumbers(root.left, currentSum) +
34                sumNumbers(root.right, currentSum);
35    }
36
37    private boolean isLeaf(TreeNode root) {
38        return root.left == null && root.right == null;
39    }
40}