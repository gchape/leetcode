// Last updated: 8/9/2026, 2:17:30 PM
1class Solution {
2    public int[] rowAndMaximumOnes(int[][] mat) {
3        int ones = 0, row = 0;
4
5        for (int i = 0; i < mat.length; i++) {
6            int currentOnes = 0;
7            for (int j = 0; j < mat[i].length; j++) {
8                if (mat[i][j] == 1) {
9                    currentOnes++;
10                }
11            }
12            if (currentOnes > ones) {
13                ones = currentOnes;
14                row = i;
15            }
16        }
17
18        return new int[]{row, ones};
19    }
20}