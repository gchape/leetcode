class Solution {
    public boolean rotateString(String s, String goal) {
        var temp = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (temp.toString().equals(goal)) {
                return true;
            }

            var top = temp.charAt(0);
            temp.deleteCharAt(0).append(top);
        }

        return false;
    }
}