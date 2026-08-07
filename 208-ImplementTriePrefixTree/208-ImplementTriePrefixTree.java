// Last updated: 8/7/2026, 11:13:06 AM
import java.util.HashMap;
import java.util.Map;

public class Trie {

    private final Node root = new Node();

    public void insert(String word) {
        Node node = root;

        for (char c : word.toCharArray()) {
            node = node.children.computeIfAbsent(c, k -> new Node());
        }

        node.isWord = true;
    }

    public boolean search(String word) {
        Node node = find(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    private Node find(String s) {
        Node node = root;

        for (char c : s.toCharArray()) {
            node = node.children.get(c);

            if (node == null) {
                return null;
            }
        }

        return node;
    }

    private static class Node {
        Map<Character, Node> children = new HashMap<>();
        boolean isWord;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */