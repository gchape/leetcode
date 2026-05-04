// Last updated: 5/4/2026, 7:18:39 PM
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        var array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i) - 97]++;
        }
        for (int i = 0; i < t.length(); i++) {
            array[t.charAt(i) - 97]--;
        }

        for (var n : array) {
            if (n != 0) {
                return false;
            }
        }
        return true;
    }
}