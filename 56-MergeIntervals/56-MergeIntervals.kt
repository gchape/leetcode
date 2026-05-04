// Last updated: 5/4/2026, 8:09:04 PM
1class Solution {
2    fun removeElement(nums: IntArray, `val`: Int): Int {
3               for ((i, element) in nums.withIndex()) {
4        if (element == `val`) {
5            nums[i] = -1
6        }
7    }
8
9    var j: Int? = null
10    var i = 0
11
12    while (i < nums.size) {
13        if (nums[i] == -1 && j == null) {
14            j = i
15        }
16
17        if (nums[i] != -1 && j != null) {
18            nums[j] = nums[i]
19            nums[i] = -1
20            i = j
21            j = null
22        }
23
24        i++
25    }
26
27    return j ?: nums.size
28    }
29}