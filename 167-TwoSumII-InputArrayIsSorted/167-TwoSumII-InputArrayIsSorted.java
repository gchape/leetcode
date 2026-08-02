// Last updated: 8/2/2026, 8:12:02 AM
1class Solution {
2    public int[] twoSum(int[] numbers, int target) {
3        int head = 0, tail = numbers.length - 1;
4
5        while (head < tail) {
6            int sum = numbers[head] + numbers[tail];
7
8            if (sum < target) {
9                head++;
10            } else if (sum > target) {
11                tail--;
12            } else {
13                return new int[] { head + 1, tail + 1 };
14            }
15        }
16
17        return null;
18    }
19}