class Solution {
    public int maxDepth(String s) {
        int depth = 0;
        var stack = new ArrayDeque<Character>();

        for (var c : s.toCharArray()) {
            if (c == '(') {
                stack.offer('(');

                depth = Math.max(depth, stack.size());
            } else if (c == ')') {
                stack.poll();
            }
        }

        return depth;
    }
}