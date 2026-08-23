// Last updated: 8/23/2026, 10:24:39 AM
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode(int x) { val = x; }
8 * }
9 */
10
11class Solution {
12
13    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
14        if (p.val < root.val && q.val < root.val) {
15            return lowestCommonAncestor(root.left, p, q);
16        }
17
18        if (p.val > root.val && q.val > root.val) {
19            return lowestCommonAncestor(root.right, p, q);
20        }
21
22        return root;
23    }
24}