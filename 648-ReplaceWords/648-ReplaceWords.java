// Last updated: 8/5/2026, 10:28:55 AM
1class Solution {
2    public String replaceWords(List<String> dictionary, String sentence) {
3        Trie trie = new Trie();
4
5        for (String root : dictionary) {
6            trie.insert(root);
7        }
8
9        StringBuilder result = new StringBuilder();
10
11        for (String word : sentence.split(" ")) {
12            String prefix = trie.shortestPrefix(word);
13
14            result.append(prefix == null ? word : prefix)
15                    .append(' ');
16        }
17
18        result.setLength(result.length() - 1);
19
20        return result.toString();
21    }
22
23    public static class Trie {
24
25        private final Node root = new Node();
26
27        public void insert(String word) {
28            Node node = root;
29
30            for (char c : word.toCharArray()) {
31                node = node.children.computeIfAbsent(c, k -> new Node());
32            }
33
34            node.isWord = true;
35        }
36
37        public boolean search(String word) {
38            Node node = find(word);
39            return node != null && node.isWord;
40        }
41
42        public boolean startsWith(String prefix) {
43            return find(prefix) != null;
44        }
45
46        public String shortestPrefix(String word) {
47            Node node = root;
48            StringBuilder prefix = new StringBuilder();
49
50            for (char c : word.toCharArray()) {
51                node = node.children.get(c);
52
53                if (node == null) {
54                    return null;
55                }
56
57                prefix.append(c);
58
59                if (node.isWord) {
60                    return prefix.toString();
61                }
62            }
63
64            return null;
65        }
66
67        private Node find(String s) {
68            Node node = root;
69
70            for (char c : s.toCharArray()) {
71                node = node.children.get(c);
72
73                if (node == null) {
74                    return null;
75                }
76            }
77
78            return node;
79        }
80
81        private static class Node {
82            Map<Character, Node> children = new HashMap<>();
83            boolean isWord;
84        }
85    }
86}