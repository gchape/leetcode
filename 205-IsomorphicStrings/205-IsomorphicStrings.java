// Last updated: 5/4/2026, 7:18:41 PM
class Solution {
    public boolean isIsomorphic(String s, String t) {
        var mapST = new HashMap<Character, Character>();
        var mapTS = new HashMap<Character, Character>();

        for (int i = 0; i < s.length(); i++) {
            var c1 = s.charAt(i);
            var c2 = t.charAt(i);

            var v1 = mapST.putIfAbsent(c1, c2);
            if (v1 != null && v1 != c2) {
                return false;
            }

            var v2 = mapTS.putIfAbsent(c2, c1);
            if (v2 != null && v2 != c1) {
                return false;
            }
        }

        return true;
    }
}