// Last updated: 9/5/2026, 9:07:38 PM
1class Solution {
2    public List<List<String>> groupAnagrams(String[] strs) {
3        var anagrams = new HashMap<String, List<String>>();
4        for (var str : strs) {
5            char[] chars = str.toCharArray();
6            Arrays.sort(chars);
7            String key = new String(chars);
8            anagrams.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
9        }
10        return new ArrayList<>(anagrams.values());
11    }
12}