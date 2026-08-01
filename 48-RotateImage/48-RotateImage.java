// Last updated: 8/1/2026, 11:13:20 PM
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            
            for (int offset = first; offset < last; offset++) {
                // save top
                int temp = matrix[first][offset];
                
                // left -> top
                matrix[first][offset] = matrix[last - (offset - first)][first];
                
                // bottom -> left
                matrix[last - (offset - first)][first] = matrix[last][last - (offset - first)];
                
                // right -> bottom
                matrix[last][last - (offset - first)] = matrix[offset][last];
                
                // top (temp) -> right
                matrix[offset][last] = temp;
            }
        }
    }
}