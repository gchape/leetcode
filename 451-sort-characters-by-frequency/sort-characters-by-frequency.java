class Solution {
    public String frequencySort(String s) {
        var map = new HashMap<Character, Integer>();

        for (char c : s.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }

        var list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.<Character, Integer>comparingByValue().reversed());

        var result = new StringBuilder();
        for (var entry : list) {
            result.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
        }

        return result.toString();
    }
}
