// Last updated: 8/23/2026, 10:04:56 AM
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
18    public int kthSmallest(TreeNode root, int k) {
19        Deque<TreeNode> stack = new ArrayDeque<>();
20
21        while (true) {
22
23            while (root != null) {
24                stack.push(root);
25                root = root.left;
26            }
27
28            root = stack.pop();
29
30            if (--k == 0) {
31                return root.val;
32            }
33
34            root = root.right;
35        }
36    }
37}