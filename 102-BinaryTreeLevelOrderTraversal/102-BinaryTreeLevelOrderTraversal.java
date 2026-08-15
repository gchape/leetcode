// Last updated: 8/15/2026, 2:49:26 PM
1class Solution {
2    public List<List<Integer>> levelOrder(TreeNode root) {
3        if (root == null) return List.of();
4
5        var q = new ArrayDeque<TreeNode>();
6        var result = new ArrayList<List<Integer>>();
7
8        q.offer(root);
9
10        while (!q.isEmpty()) {
11            int size = q.size();
12            var level = new ArrayList<Integer>(size);
13
14            for (int i = 0; i < size; i++) {
15                var node = q.poll();
16
17                level.add(node.val);
18
19                if (node.left != null) q.offer(node.left);
20                if (node.right != null) q.offer(node.right);
21            }
22
23            result.add(level);
24        }
25
26        return result;
27    }
28}