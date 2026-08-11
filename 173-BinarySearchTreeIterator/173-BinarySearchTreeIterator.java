// Last updated: 8/11/2026, 5:55:46 PM
1class BSTIterator {
2    private Queue<Integer> queue;
3
4    public BSTIterator(TreeNode root) {
5        queue = new LinkedList<>();
6        inorder(root); // Flatten the tree upfront
7    }
8    
9    private void inorder(TreeNode root) {
10        if (root == null) return;
11        inorder(root.left);
12        queue.offer(root.val);
13        inorder(root.right);
14    }
15    
16    public int next() {
17        return queue.poll();
18    }
19    
20    public boolean hasNext() {
21        return !queue.isEmpty();
22    }
23}