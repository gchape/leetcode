// Last updated: 8/19/2026, 8:17:11 AM
1import java.text.BreakIterator;
2
3class Solution {
4
5    public String reverseWords(String s) {
6        var wordIterator = BreakIterator.getWordInstance();
7        wordIterator.setText(s);
8
9        var sb = new StringBuilder();
10        int start = wordIterator.first();
11        for (int end = wordIterator.next(); end != BreakIterator.DONE; start = end, end = wordIterator.next()) {
12            String token = s.substring(start, end);
13            if (!token.isBlank()) {
14                if (sb.length() > 0)
15                    sb.insert(0, " ");
16                sb.insert(0, token);
17            }
18        }
19        return sb.toString();
20    }
21}