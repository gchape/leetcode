// Last updated: 8/20/2026, 7:10:41 PM
1class Solution {
2
3    public boolean canConstruct(String ransomNote, String magazine) {
4        var letters = new HashMap<Character, Integer>();
5
6        for (var c : ransomNote.toCharArray()) {
7            letters.merge(c, 1, (oldV, newV) -> oldV + newV);
8        }
9
10        for (var c : magazine.toCharArray()) {
11            if (!letters.containsKey(c)) {
12                continue;
13            }
14
15            if (letters.compute(c, (_, v) -> v - 1) == 0) {
16                letters.remove(c);   
17            }
18        }
19
20        return letters.size() == 0;
21    }
22}