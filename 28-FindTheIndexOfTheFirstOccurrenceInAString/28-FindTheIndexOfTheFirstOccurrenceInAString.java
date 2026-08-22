// Last updated: 8/23/2026, 12:08:44 AM
class Solution {

    public int strStr(String haystack, String needle) {
        int last = haystack.length() - needle.length();

        for (int i = 0; i <= last; i++) {
            boolean found = true;

            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    found = false;
                    break;
                }
            }

            if (found)
                return i;
        }

        return -1;
    }
}