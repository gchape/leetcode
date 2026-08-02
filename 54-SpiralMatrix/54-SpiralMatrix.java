// Last updated: 8/2/2026, 6:12:24 PM
1class Solution {
2    public List<Integer> spiralOrder(int[][] matrix) {
3        List<Integer> cells = new ArrayList<>();
4
5        int top = 0;
6        int bottom = matrix.length - 1;
7        int left = 0;
8        int right = matrix[0].length - 1;
9
10        while (top <= bottom && left <= right) {
11
12            // Left -> Right
13            for (int col = left; col <= right; col++) {
14                cells.add(matrix[top][col]);
15            }
16            top++;
17
18            // Top -> Bottom
19            for (int row = top; row <= bottom; row++) {
20                cells.add(matrix[row][right]);
21            }
22            right--;
23
24            // Right -> Left
25            if (top <= bottom) {
26                for (int col = right; col >= left; col--) {
27                    cells.add(matrix[bottom][col]);
28                }
29                bottom--;
30            }
31
32            // Bottom -> Top
33            if (left <= right) {
34                for (int row = bottom; row >= top; row--) {
35                    cells.add(matrix[row][left]);
36                }
37                left++;
38            }
39        }
40
41        return cells;
42    }
43}