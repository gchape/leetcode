// Last updated: 8/10/2026, 10:23:38 PM
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
17    public List<Integer> inorderTraversal(TreeNode root) {
18        var result = new ArrayList<Integer>();
19
20        traverse(result, root);
21
22        return result;
23    }
24
25    private void traverse(List<Integer> nodes, TreeNode root) {
26        if (root == null) {
27            return;
28        }
29
30        traverse(nodes, root.left);
31        nodes.add(root.val);
32        traverse(nodes, root.right);
33    }
34}