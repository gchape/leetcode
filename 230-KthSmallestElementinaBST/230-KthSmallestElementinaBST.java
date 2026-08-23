// Last updated: 8/23/2026, 9:59:15 AM
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
17    private int kth = 0;
18    private int kthSmallest = -1;
19
20    public int kthSmallest(TreeNode root, int k) {
21        kthSmallestHelper(root, k);
22
23        return kthSmallest;
24    }
25
26    private void kthSmallestHelper(TreeNode root, int k) {
27        if (root == null) return;
28
29        kthSmallestHelper(root.left, k);
30        kth++;
31
32        if (kth == k) {
33            kthSmallest = root.val;
34        }
35
36        kthSmallestHelper(root.right, k);
37    }
38}