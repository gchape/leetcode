// Last updated: 8/15/2026, 2:15:07 PM
1class Solution {
2    public String simplifyPath(String path) {
3        Deque<String> dirs = new ArrayDeque<>();
4
5        for (var dir : path.split("/")) {
6            switch (dir) {
7                case "", "." -> {
8                }
9                case ".." -> {
10                    if (!dirs.isEmpty())
11                        dirs.pop();
12                }
13                default -> dirs.push(dir);
14            }
15        }
16
17        var joiner = new java.util.StringJoiner("/", "/", "");
18        while (!dirs.isEmpty()) {
19            joiner.add(dirs.pollLast());
20        }
21
22        return joiner.toString();
23    }
24}