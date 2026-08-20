// Last updated: 8/20/2026, 7:33:31 PM
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode(int x) { val = x; }
8 * }
9 */
10class Solution {
11
12    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
13        if (root == null || root == p || root == q) {
14            return root;
15        }
16
17        var left = lowestCommonAncestor(root.left, p, q);
18        var right = lowestCommonAncestor(root.right, p, q);
19
20        if (left != null && right != null) {
21            return root;
22        }
23
24        return left != null ? left : right;
25    }
26}