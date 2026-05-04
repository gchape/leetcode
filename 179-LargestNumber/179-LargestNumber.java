// Last updated: 5/4/2026, 7:18:44 PM
class Solution {
    public String largestNumber(int[] nums) {
        var result = Arrays.stream(nums)
                .mapToObj(Integer::toString)
                .sorted((x, y) -> (y + x).compareTo(x + y))
                .collect(Collectors.joining());

        return result.startsWith("0") ? "0" : result;
    }
}