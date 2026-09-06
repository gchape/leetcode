// Last updated: 9/6/2026, 8:21:00 AM
1class Solution {
2
3    public int firstUniqChar(String s) {
4        Map<Character, Integer> seen = HashMap.newHashMap(s.length());
5
6        for (var c : s.toCharArray()) {
7            seen.merge(c, 1, (old_, new_) -> old_ + new_);
8        }
9
10        for (int i = 0; i < s.length(); i++) {
11            if (seen.get(s.charAt(i)) == 1) {
12                return i;
13            }
14        }
15
16        return -1;
17    }
18}