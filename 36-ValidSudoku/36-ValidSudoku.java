// Last updated: 8/3/2026, 4:35:14 PM
1class Solution {
2    public boolean isValidSudoku(char[][] board) {
3        Set<String> seen = new HashSet<>(243);
4
5        for (int i = 0; i < 9; i++) {
6            for (int j = 0; j < 9; j++) {
7                char value = board[i][j];
8
9                if (value == '.') {
10                    continue;
11                }
12
13                String rowKey = "[" + i + "]" + value;
14                String colKey = value + "[" + j + "]";
15                String boxKey = "{" + getGridIndex(i, j) + "}" + value;
16
17                if (!seen.add(rowKey) ||
18                        !seen.add(colKey) ||
19                        !seen.add(boxKey)) {
20                    return false;
21                }
22            }
23        }
24
25        return true;
26    }
27
28    private int getGridIndex(int row, int col) {
29        return (row / 3) * 3 + (col / 3);
30    }
31}