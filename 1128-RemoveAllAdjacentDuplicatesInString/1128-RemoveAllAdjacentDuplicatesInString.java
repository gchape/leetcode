// Last updated: 5/4/2026, 7:18:27 PM
class Solution {
    public String removeDuplicates(String s) {
        if (s.length() == 1) return s;

        var stack = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int size = stack.length();

            if (size > 0 && stack.charAt(size - 1) == s.charAt(i)) {
                stack.deleteCharAt(size - 1);
            } else {
                stack.append(s.charAt(i));
            }
        }

        return stack.toString();
    }
}