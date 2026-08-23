// Last updated: 8/23/2026, 11:18:03 AM
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
17    public TreeNode bstFromPreorder(int[] preorder) {
18        return bstFromPreorder(preorder, 0, preorder.length);
19    }
20
21    public TreeNode bstFromPreorder(int[] preorder, int start, int end) {
22        if (end - start == 1) {
23            return new TreeNode(preorder[start]);
24        }
25
26        TreeNode root = new TreeNode(preorder[start]);
27
28        int left = start + 1;
29        while (left < end && preorder[start] > preorder[left]) {
30            left++;
31        }
32        // left is now a last index of the left subtree
33
34        // construct a left subtree
35        if (left != start + 1) {
36            root.left = bstFromPreorder(preorder, start + 1, left);
37        }
38        // construct a right subtree
39        if (left != end) {
40            root.right = bstFromPreorder(preorder, left, end);
41        }
42
43        return root;
44    }
45}