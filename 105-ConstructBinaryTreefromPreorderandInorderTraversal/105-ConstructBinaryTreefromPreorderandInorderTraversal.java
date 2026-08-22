// Last updated: 8/22/2026, 11:29:45 PM
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
19        return build(preorder, inorder);
20    }
21
22    private TreeNode build(int[] preorder, int[] inorder) {
23        if (preorder.length == 0) {
24            return null;
25        }
26
27        int rootValue = preorder[0];
28        TreeNode root = new TreeNode(rootValue);
29
30        int rootIndex = 0;
31        while (inorder[rootIndex] != rootValue) {
32            rootIndex++;
33        }
34
35        // Number of nodes in left subtree
36        int leftSize = rootIndex;
37
38        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, 1 + leftSize);
39        int[] leftInorder = Arrays.copyOfRange(inorder, 0, leftSize);
40
41        int[] rightPreorder = Arrays.copyOfRange(
42            preorder, 1 + leftSize, preorder.length
43        );
44        int[] rightInorder = Arrays.copyOfRange(
45            inorder, leftSize + 1, inorder.length
46        );
47
48        root.left = build(leftPreorder, leftInorder);
49        root.right = build(rightPreorder, rightInorder);
50
51        return root;
52    }
53}