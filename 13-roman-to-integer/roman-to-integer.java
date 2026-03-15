class Solution {
    public int romanToInt(String s) {
        var map = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
        );

        int res = 0;
        char prev = 'Z';
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(prev) 
                    && map.get(prev) < map.get(s.charAt(i))) {
                res -= (2 * map.get(prev));
            }

            res += map.get(s.charAt(i));
            prev = s.charAt(i);
        }

        return res;
    }
}