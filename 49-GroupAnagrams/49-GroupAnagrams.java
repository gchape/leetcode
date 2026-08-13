// Last updated: 8/13/2026, 8:18:37 PM
1class Solution {
2    public List<List<String>> groupAnagrams(String[] strs) {
3        var anagrams = new HashMap<String, List<String>>();
4        for (var str : strs) {
5            char[] chars = str.toCharArray();
6            Arrays.sort(chars);
7
8            var anagram = new String(chars);
9            anagrams.compute(anagram, (k, v) -> Objects.requireNonNullElseGet(v, ArrayList::new))
10                    .add(str);
11        }
12
13        return new ArrayList<>(anagrams.values());
14    }
15}