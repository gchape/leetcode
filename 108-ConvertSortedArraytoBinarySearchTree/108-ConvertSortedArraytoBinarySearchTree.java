// Last updated: 8/23/2026, 12:25:36 PM
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
18    public TreeNode sortedArrayToBST(int[] nums) {
19        return sortedArrayToBST(nums, 0, nums.length - 1);
20    }
21
22    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
23        if (left > right) {
24            return null;
25        }
26        if (left == right) {
27            return new TreeNode(nums[left]);
28        }
29
30        int mid = left + (right - left) / 2;
31
32        TreeNode root = new TreeNode(nums[mid]);
33
34        root.left = sortedArrayToBST(nums, left, mid - 1);
35        root.right = sortedArrayToBST(nums, mid + 1, right);
36
37        return root;
38    }
39}