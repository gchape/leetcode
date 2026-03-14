class Solution {
    public String frequencySort(String s) {
        var map = new HashMap<Character, Integer>();

        for (char c : s.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }

        return map.entrySet()
                .stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey()))
                .map(e -> String.valueOf(e.getKey()).repeat(e.getValue()))
                .collect(Collectors.joining());
    }
}