// Last updated: 8/15/2026, 1:27:19 PM
1class Solution {
2    public int evalRPN(String[] tokens) {
3        var stack = new ArrayDeque<Integer>();
4
5        for (var token : tokens) {
6            switch (token) {
7                case "+": {
8                    stack.push(stack.pop() + stack.pop());
9                    break;
10                }
11                case "-": {
12                    int right = stack.pop();
13                    int left = stack.pop();
14                    stack.push(left - right);
15                    break;
16                }
17                case "*": {
18                    stack.push(stack.pop() * stack.pop());
19                    break;
20                }
21                case "/": {
22                    int right = stack.pop();
23                    int left = stack.pop();
24                    stack.push(left / right);
25                    break;
26                }
27                default:
28                    stack.push(Integer.parseInt(token));
29            }
30        }
31
32        return stack.pop();
33    }
34}