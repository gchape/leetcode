// Last updated: 8/12/2026, 5:54:43 PM
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length - 1;

        // Find the row that could contain target
        while (top <= bottom) {
            int mid = top + (bottom - top) / 2;

            if (matrix[mid][0] <= target) {
                top = mid + 1;
            } else {
                bottom = mid - 1;
            }
        }

        int row = bottom;

        if (row < 0) {
            return false;
        }

        // Binary search inside the row
        int left = 0;
        int right = matrix[row].length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (matrix[row][mid] < target) {
                left = mid + 1;
            } else if (matrix[row][mid] > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}