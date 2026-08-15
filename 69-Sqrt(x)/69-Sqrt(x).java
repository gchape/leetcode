// Last updated: 8/15/2026, 9:04:35 PM
1class Solution {
2    public int mySqrt(int x) {
3        int left = 0, right = x;
4
5        while (left <= right) {
6            int mid = left + (right - left) / 2;
7            
8            long square = (long) mid * mid;
9
10            if (square == x) {
11                return mid;
12            }
13
14            if (square > x) {
15                right = mid - 1;
16            } else {
17                left = mid + 1;
18            }
19        }
20
21        return right;
22    }
23}