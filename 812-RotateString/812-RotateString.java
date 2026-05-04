// Last updated: 5/4/2026, 7:18:31 PM
class Solution {
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }
}