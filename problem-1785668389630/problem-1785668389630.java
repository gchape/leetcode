// Last updated: 8/2/2026, 2:59:49 PM
1class Solution {
2    public int countPrimes(int n) {
3        if (n <= 2)
4            return 0;
5
6        boolean[] isNotPrime = new boolean[n];
7        isNotPrime[0] = true;
8        isNotPrime[1] = true;
9
10        for (int i = 2; i * i < n; i++) {
11            if (!isNotPrime[i]) {
12                for (int j = i * i; j < n; j += i) {
13                    isNotPrime[j] = true;
14                }
15            }
16        }
17
18        int result = 0;
19        for (int i = 0; i < n; i++) {
20            if (!isNotPrime[i]) {
21                result++;
22            }
23        }
24
25        return result;
26    }
27}