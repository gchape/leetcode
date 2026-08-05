// Last updated: 8/5/2026, 10:25:17 AM
1class Solution {
2    public String replaceWords(List<String> dictionary, String sentence) {
3        var trie = new Trie();
4        var result = new StringBuilder();
5
6        for (String word : dictionary) {
7            trie.insert(word);
8        }
9
10        for (String word : sentence.split(" ")) {
11            StringBuilder prefix = new StringBuilder();
12            boolean replaced = false;
13
14            for (char c : word.toCharArray()) {
15                prefix.append(c);
16
17                if (trie.search(prefix.toString())) {
18                    result.append(prefix).append(' ');
19                    replaced = true;
20                    break;
21                }
22            }
23
24            if (!replaced) {
25                result.append(word).append(' ');
26            }
27        }
28        
29        return result.toString().stripTrailing();
30    }
31
32    public static class Trie {
33
34        private final Node root = new Node();
35
36        public void insert(String word) {
37            Node node = root;
38
39            for (char c : word.toCharArray()) {
40                node = node.children.computeIfAbsent(c, k -> new Node());
41            }
42
43            node.isWord = true;
44        }
45
46        public boolean search(String word) {
47            Node node = find(word);
48            return node != null && node.isWord;
49        }
50
51        public boolean startsWith(String prefix) {
52            return find(prefix) != null;
53        }
54
55        private Node find(String s) {
56            Node node = root;
57
58            for (char c : s.toCharArray()) {
59                node = node.children.get(c);
60
61                if (node == null) {
62                    return null;
63                }
64            }
65
66            return node;
67        }
68
69        private static class Node {
70            Map<Character, Node> children = new HashMap<>();
71            boolean isWord;
72        }
73    }
74}