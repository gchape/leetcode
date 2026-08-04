// Last updated: 8/4/2026, 10:21:19 PM
1class Solution {
2    public String reverseWords(String s) {
3        var word = new StringBuilder();
4        var words = new ArrayList<String>();
5
6        for (int i = 0; i < s.length(); i++) {
7            if (Character.isLetter(s.charAt(i))
8                    || Character.isDigit(s.charAt(i))) {
9                word.append(s.charAt(i));
10            } else if (Character.isSpaceChar(s.charAt(i))) {
11                if (!word.isEmpty()) {
12                    words.addFirst(String.valueOf(word));
13                    word = new StringBuilder();
14                }
15            }
16        }
17
18        if (!word.isEmpty()) {
19            words.addFirst(String.valueOf(word));
20        }
21
22        return String.join(" ", words);
23    }
24}