// Last updated: 8/22/2026, 11:57:46 PM
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
18    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
19        List<Integer> leaves1 = new ArrayList<>();
20        List<Integer> leaves2 = new ArrayList<>();
21
22        appendLeaves(root1, leaves1);
23        appendLeaves(root2, leaves2);
24
25        return leaves1.equals(leaves2);
26    }
27
28    private void appendLeaves(TreeNode root, List<Integer> list) {
29        if (root == null) {
30            return;
31        }
32
33        if (root.left == null && root.right == null) {
34            list.add(root.val);
35        }
36
37        appendLeaves(root.left, list);
38        appendLeaves(root.right, list);
39    }
40}