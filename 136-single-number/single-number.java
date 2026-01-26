class Solution {
    public int singleNumber(int[] nums) {
        var m = new HashMap<Integer, Integer>();

        for (int i : nums) {
            m.compute(i, (_, v) -> {
                if (v == null) {
                    return 1;
                } else {
                    return v + 1;
                }
            });
        }

        for (var e : m.entrySet()) {
            if (e.getValue() == 1) {
                return e.getKey();
            }
        }

        return -1;
    }
}