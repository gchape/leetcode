// Last updated: 9/5/2026, 8:59:29 PM
1class Solution {
2
3    public boolean isValid(String s) {
4        var stack = new ArrayDeque<Character>();
5
6        for (int i = 0; i < s.length(); i++) {
7            char c = s.charAt(i);
8            
9            if (c == '(' || c == '[' || c == '{') {
10                stack.push(c);
11            } else {
12                var open = stack.peek();
13                if (open == null) return false;
14                if (matches(open, c)) stack.pop();
15                else return false;
16            }
17        }
18
19        return stack.isEmpty();
20    }
21
22    private boolean matches(char open, char close) {
23        if (open == '(') return close == ')';
24        if (open == '{') return close == '}';
25        if (open == '[') return close == ']';
26        return false;
27    }
28}