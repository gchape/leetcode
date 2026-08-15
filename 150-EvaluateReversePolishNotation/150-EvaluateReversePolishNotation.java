// Last updated: 8/15/2026, 1:25:07 PM
1class Solution {
2    public int evalRPN(String[] tokens) {
3        var eval = new ArrayDeque<Integer>();
4
5        for (var token : tokens) {
6            try {
7                int digit = Integer.parseInt(token);
8                eval.push(digit);
9            } catch (NumberFormatException e) {
10                int result;
11                if (eval.size() > 1) {
12                    int right = eval.pop();
13                    int left = eval.pop();
14
15                    result = switch (token) {
16                        case "/" -> left / right;
17                        case "+" -> left + right;
18                        case "*" -> left * right;
19                        case "-" -> left - right;
20                        default -> throw new IllegalStateException("Unexpected value: " + token);
21                    };
22
23                    eval.push(result);
24                } else {
25                    result = switch (token) {
26                        case "+" -> eval.pop();
27                        case "-" -> -eval.pop();
28                        default -> throw new IllegalStateException("Unexpected value: " + token);
29                    };
30
31                    eval.push(result);
32                }
33            }
34        }
35
36        return eval.pop();
37    }
38}