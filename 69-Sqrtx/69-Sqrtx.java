// Last updated: 8/12/2026, 5:54:48 PM
class Solution {
    public int mySqrt(int x) {
        int i = 0;
        for (; (long) (i + 1) * (i + 1) <= x; i++) {
        }

        return i;
    }
}