class Solution {
    public boolean isValid(String s) {
        var m = Map.of('(', ')', '{', '}', '[', ']');
        var stack = new ArrayDeque<Character>();

        for (int i = 0; i < s.length(); i++) {
            if (m.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else if (m.get(stack.peek()) == s.charAt(i)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}