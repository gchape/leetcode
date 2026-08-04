// Last updated: 8/4/2026, 6:50:49 PM
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
20
21        for (int i = 0; i < pattern.length(); i++) {
22            char p = pattern.charAt(i);
23            char w = word.charAt(i);
24
25            if (!mappings.containsKey(p)) {
26                if (mappings.containsValue(w)) {
27                    return false;
28                }
29                mappings.put(p, w);
30            } else if (mappings.get(p) != w) {
31                return false;
32            }
33        }
34
35        return true;
36    }
37}