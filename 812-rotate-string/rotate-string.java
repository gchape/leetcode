class Solution {
    public boolean rotateString(String s, String goal) {
        var temp = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (temp.toString().equals(goal)) {
                return true;
            }
            temp.append(temp.charAt(0)).deleteCharAt(0);
        }

        return false;
    }
}