// Last updated: 8/15/2026, 2:48:12 PM
1class Solution {
2    public List<List<Integer>> levelOrder(TreeNode root) {
3        if (root == null) return List.of();
4
5        Deque<TreeNode> q = new ArrayDeque<>();
6        List<List<Integer>> result = new ArrayList<>();
7
8        q.offer(root);
9
10        while (!q.isEmpty()) {
11            List<Integer> level = new ArrayList<>();
12            Deque<TreeNode> qNext = new ArrayDeque<>();
13
14            while (!q.isEmpty()) {
15                var node = q.poll();
16
17                level.add(node.val);
18
19                if (node.left != null) {
20                    qNext.offer(node.left);
21                }
22
23                if (node.right != null) {
24                    qNext.offer(node.right);
25                }
26            }
27
28            result.add(level);
29            q = qNext;
30        }
31
32        return result;
33    }
34}