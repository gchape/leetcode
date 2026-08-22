// Last updated: 8/22/2026, 10:50:33 PM
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
18    public TreeNode buildTree(int[] preorder, int[] inorder) {
19        TreeNode root = new TreeNode(preorder[0]);
20
21        Deque<TreeNode> stack = new ArrayDeque<>();
22        stack.push(root);
23
24        int inorderIndex = 0;
25
26        for (int i = 1; i < preorder.length; i++) {
27            TreeNode node = stack.peek();
28
29            if (node.val != inorder[inorderIndex]) {
30                node.left = new TreeNode(preorder[i]);
31                stack.push(node.left);
32            } else {
33                while (!stack.isEmpty() &&
34                       stack.peek().val == inorder[inorderIndex]) {
35                    node = stack.pop();
36                    inorderIndex++;
37                }
38
39                node.right = new TreeNode(preorder[i]);
40                stack.push(node.right);
41            }
42        }
43
44        return root;
45    }
46}