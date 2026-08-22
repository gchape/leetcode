// Last updated: 8/23/2026, 12:07:35 AM
import java.util.*;

class Solution {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();

        int n = s.length();
        int m = 10;

        if (n < m) return result;

        Set<String> seen = new HashSet<>();
        Set<String> added = new HashSet<>();

        for (int i = 0; i <= n - m; i++) {
            String window = s.substring(i, i + m);

            // Java's String.equals() / hashCode() already does the heavy lifting -
            // no manual hashing needed at all.
            if (!seen.add(window)) {
                // add() returns false if it was already in the set -> it's a repeat
                if (added.add(window)) {
                    result.add(window);
                }
            }
        }

        return result;
    }
}