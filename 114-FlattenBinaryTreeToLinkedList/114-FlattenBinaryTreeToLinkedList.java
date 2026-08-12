// Last updated: 8/12/2026, 5:54:38 PM
class Solution {
    public void flatten(TreeNode root) {
        flattenTree(root);
    }

    private TreeNode flattenTree(TreeNode root) {
        if (root == null)
            return null;

        var leftTail = flattenTree(root.left);
        var rightTail = flattenTree(root.right);

        if (leftTail != null) {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        return rightTail != null ? rightTail
                : leftTail != null ? leftTail
                        : root;
    }
}