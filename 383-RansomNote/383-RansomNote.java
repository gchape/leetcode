// Last updated: 8/20/2026, 7:14:11 PM
1class Solution {
2
3    public boolean canConstruct(String ransomNote, String magazine) {
4        var letters = new HashMap<Character, Integer>();
5
6        for (var c : ransomNote.toCharArray()) {
7            letters.merge(c, 1, Integer::sum);
8        }
9
10        for (var c : magazine.toCharArray()) {
11            if (!letters.containsKey(c))
12                continue;
13
14            if (letters.compute(c, (_, v) -> v - 1) == 0)
15                letters.remove(c);
16        }
17
18        return letters.isEmpty();
19    }
20}