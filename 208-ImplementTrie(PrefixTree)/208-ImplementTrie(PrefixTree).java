// Last updated: 8/5/2026, 10:01:02 AM
1import java.util.HashMap;
2import java.util.Map;
3
4public class Trie {
5
6    private final Node root = new Node();
7
8    public void insert(String word) {
9        Node node = root;
10
11        for (char c : word.toCharArray()) {
12            node = node.children.computeIfAbsent(c, k -> new Node());
13        }
14
15        node.isWord = true;
16    }
17
18    public boolean search(String word) {
19        Node node = find(word);
20        return node != null && node.isWord;
21    }
22
23    public boolean startsWith(String prefix) {
24        return find(prefix) != null;
25    }
26
27    private Node find(String s) {
28        Node node = root;
29
30        for (char c : s.toCharArray()) {
31            node = node.children.get(c);
32
33            if (node == null) {
34                return null;
35            }
36        }
37
38        return node;
39    }
40
41    private static class Node {
42        Map<Character, Node> children = new HashMap<>();
43        boolean isWord;
44    }
45}
46
47/**
48 * Your Trie object will be instantiated and called as such:
49 * Trie obj = new Trie();
50 * obj.insert(word);
51 * boolean param_2 = obj.search(word);
52 * boolean param_3 = obj.startsWith(prefix);
53 */