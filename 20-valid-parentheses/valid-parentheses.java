class Solution {
    public boolean isValid(String s) {
        var m = Map.of('(', ')', '{', '}', '[', ']');
        var stack = new ArrayDeque<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (m.containsKey(c)) {
                stack.push(c);
            } else if (stack.isEmpty() || m.get(stack.peek()) != c) {
                return false;
            } else {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}