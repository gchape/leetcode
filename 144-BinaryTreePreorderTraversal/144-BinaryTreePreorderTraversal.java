// Last updated: 8/10/2026, 10:28:59 PM
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
17    public List<Integer> preorderTraversal(TreeNode root) {
18        var result = new ArrayList<Integer>();
19
20        traverse(result, root);
21
22        return result;
23    }
24
25    private void traverse(List<Integer> nodes, TreeNode root) {
26        if (root == null) return;
27
28        nodes.add(root.val);
29        traverse(nodes, root.left);
30        traverse(nodes, root.right);
31    }
32}