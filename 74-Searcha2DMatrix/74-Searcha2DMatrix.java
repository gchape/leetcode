// Last updated: 8/9/2026, 1:52:50 PM
1class Solution {
2    public boolean searchMatrix(int[][] matrix, int target) {
3        int top = 0;
4        int bottom = matrix.length - 1;
5
6        // Find the row that could contain target
7        while (top <= bottom) {
8            int mid = top + (bottom - top) / 2;
9
10            if (matrix[mid][0] <= target) {
11                top = mid + 1;
12            } else {
13                bottom = mid - 1;
14            }
15        }
16
17        int row = bottom;
18
19        if (row < 0) {
20            return false;
21        }
22
23        // Binary search inside the row
24        int left = 0;
25        int right = matrix[row].length - 1;
26
27        while (left <= right) {
28            int mid = left + (right - left) / 2;
29
30            if (matrix[row][mid] < target) {
31                left = mid + 1;
32            } else if (matrix[row][mid] > target) {
33                right = mid - 1;
34            } else {
35                return true;
36            }
37        }
38
39        return false;
40    }
41}