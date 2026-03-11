class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }

        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length - 1];

        return join(first, last, 0);
    }

    private String join(String first, String last, int i) {
        if (i == first.length() || i == last.length()) {
            return "";
        }

        if (first.charAt(i) == last.charAt(i)) {
            return first.charAt(i) + "" + join(first, last, i + 1);
        }

        return "";
    }
}