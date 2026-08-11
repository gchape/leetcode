// Last updated: 8/11/2026, 7:33:25 PM
1class Solution {
2    public String simplifyPath(String path) {
3        var stack = new ArrayDeque<String>();
4
5        for (var part : path.split("/")) {
6            if (part.isBlank() || part.equals(".")) continue;
7
8            if (part.equals("..")) {
9                if (!stack.isEmpty()) stack.removeLast();
10            } else {
11                stack.addLast(part);
12            }
13        }
14
15        return "/" + String.join("/", stack);
16    }
17}