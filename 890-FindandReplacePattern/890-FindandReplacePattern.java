// Last updated: 8/4/2026, 7:01:05 PM
1class Solution {
2    public List<String> findAndReplacePattern(String[] words, String pattern) {
3        List<String> result = new ArrayList<>();
4
5        for (var word : words) {
6            if (matches(word, pattern)) {
7                result.add(word);
8            }
9        }
10
11        return result;
12    }
13
14    private boolean matches(String word, String pattern) {
15        if (word.length() != pattern.length()) {
16            return false;
17        }
18
19        Map<Character, Character> mappings = new HashMap<>();
20        Set<Character> values = new HashSet<>();
21
22        for (int i = 0; i < pattern.length(); i++) {
23            char p = pattern.charAt(i);
24            char w = word.charAt(i);
25
26            if (!mappings.containsKey(p)) {
27                if (values.contains(w)) {
28                    return false;
29                }
30                mappings.put(p, w);
31                values.add(w);
32            } else if (mappings.get(p) != w) {
33                return false;
34            }
35        }
36
37        return true;
38    }
39}