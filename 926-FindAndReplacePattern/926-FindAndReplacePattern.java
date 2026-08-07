// Last updated: 8/7/2026, 11:12:50 AM
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();

        for (var word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }

        return result;
    }

    private boolean matches(String word, String pattern) {
        if (word.length() != pattern.length()) {
            return false;
        }

        Map<Character, Character> mappings = new HashMap<>();
        Set<Character> values = new HashSet<>();

        for (int i = 0; i < pattern.length(); i++) {
            char p = pattern.charAt(i);
            char w = word.charAt(i);

            if (!mappings.containsKey(p)) {
                if (values.contains(w)) {
                    return false;
                }
                mappings.put(p, w);
                values.add(w);
            } else if (mappings.get(p) != w) {
                return false;
            }
        }

        return true;
    }
}