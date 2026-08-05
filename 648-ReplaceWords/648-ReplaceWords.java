// Last updated: 8/5/2026, 10:22:47 AM
1class Solution {
2    public String replaceWords(List<String> dictionary, String sentence) {
3        var trie = new Trie();
4        var result = new StringBuilder();
5
6        for (String word : dictionary) {
7            trie.insert(word);
8        }
9
10        Arrays.stream(sentence.split(" "))
11                .forEach(word -> {
12                    var sb = new StringBuilder();
13                    for (int i = 0; i < word.length(); i++) {
14                        sb.append(word.charAt(i));
15
16                        if (trie.search(sb.toString())) {
17                            result.append(sb).append(" ");
18                            word = null;
19                            break;
20                        }
21                    }
22                    if (word != null) result.append(word).append(" ");
23                });
24
25        return result.toString().stripTrailing();
26    }
27    
28    public static class Trie {
29
30        private final Node root = new Node();
31
32        public void insert(String word) {
33            Node node = root;
34
35            for (char c : word.toCharArray()) {
36                node = node.children.computeIfAbsent(c, k -> new Node());
37            }
38
39            node.isWord = true;
40        }
41
42        public boolean search(String word) {
43            Node node = find(word);
44            return node != null && node.isWord;
45        }
46
47        public boolean startsWith(String prefix) {
48            return find(prefix) != null;
49        }
50
51        private Node find(String s) {
52            Node node = root;
53
54            for (char c : s.toCharArray()) {
55                node = node.children.get(c);
56
57                if (node == null) {
58                    return null;
59                }
60            }
61
62            return node;
63        }
64
65        private static class Node {
66            Map<Character, Node> children = new HashMap<>();
67            boolean isWord;
68        }
69    }
70}