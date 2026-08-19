// Last updated: 8/19/2026, 8:19:50 AM
1import java.text.BreakIterator;
2
3class Solution {
4
5    public String reverseWords(String s) {
6        var wordIterator = BreakIterator.getWordInstance();
7        wordIterator.setText(s);
8
9        var words = new ArrayDeque<String>(); // or a List you iterate in reverse
10
11        int start = wordIterator.first();
12        for (int end = wordIterator.next(); end != BreakIterator.DONE; start = end, end = wordIterator.next()) {
13            String token = s.substring(start, end);
14            if (!token.isBlank()) {
15                words.addLast(token);
16            }
17        }
18
19        return String.join(" ", words.reversed()); // Java 21+, or iterate a List backwards
20    }
21}