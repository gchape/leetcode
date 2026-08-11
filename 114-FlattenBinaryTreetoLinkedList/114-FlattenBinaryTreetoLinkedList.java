// Last updated: 8/11/2026, 5:33:16 PM
1class Solution {
2    public void flatten(TreeNode root) {
3        flattenTree(root);
4    }
5
6    private TreeNode flattenTree(TreeNode root) {
7        if (root == null)
8            return null;
9
10        var leftTail = flattenTree(root.left);
11        var rightTail = flattenTree(root.right);
12
13        if (leftTail != null) {
14            leftTail.right = root.right;
15            root.right = root.left;
16            root.left = null;
17        }
18
19        return rightTail != null ? rightTail
20                : leftTail != null ? leftTail
21                        : root;
22    }
23}