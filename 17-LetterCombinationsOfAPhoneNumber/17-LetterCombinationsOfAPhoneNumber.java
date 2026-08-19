// Last updated: 8/19/2026, 9:34:41 AM
class Solution {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        addAllCombinations(result, new StringBuilder(), digits, 0);
        return result;
    }

    private void addAllCombinations(
            List<String> result,
            StringBuilder sb,
            String digits,
            int i) {

        if (i >= digits.length()) {
            result.add(sb.toString());
            return;
        }

        int digit = digits.charAt(i) - '0';
        int start = (digit - 2) * 3;

        if (digit > 7)
            start++;

        int end = start + (digit == 7 || digit == 9 ? 4 : 3);

        for (; start < end; start++) {
            sb.append((char) ('a' + start));

            addAllCombinations(result, sb, digits, i + 1);

            sb.deleteCharAt(sb.length() - 1);
        }
    }
}