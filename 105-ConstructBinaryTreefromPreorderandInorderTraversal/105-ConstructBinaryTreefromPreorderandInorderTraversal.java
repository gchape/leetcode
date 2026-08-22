// Last updated: 8/22/2026, 11:30:45 PM
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
19        return build(preorder, inorder, 0, 0, inorder.length);
20    }
21
22    private TreeNode build(
23            int[] preorder,
24            int[] inorder,
25            int preorderStart,
26            int inorderStart,
27            int inorderEnd) {
28
29        if (inorderStart >= inorderEnd) {
30            return null;
31        }
32
33        int rootValue = preorder[preorderStart];
34
35        int rootIndex = inorderStart;
36        while (inorder[rootIndex] != rootValue) {
37            rootIndex++;
38        }
39
40        int leftSize = rootIndex - inorderStart;
41
42        TreeNode root = new TreeNode(rootValue);
43
44        root.left = build(
45                preorder,
46                inorder,
47                preorderStart + 1,
48                inorderStart,
49                rootIndex
50        );
51
52        root.right = build(
53                preorder,
54                inorder,
55                preorderStart + 1 + leftSize,
56                rootIndex + 1,
57                inorderEnd
58        );
59
60        return root;
61    }
62}