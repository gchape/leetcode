// Last updated: 8/12/2026, 5:52:32 PM
class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int ones = 0, row = 0;

        for (int i = 0; i < mat.length; i++) {
            int currentOnes = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    currentOnes++;
                }
            }
            if (currentOnes > ones) {
                ones = currentOnes;
                row = i;
            }
        }

        return new int[]{row, ones};
    }
}