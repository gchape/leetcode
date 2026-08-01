// Last updated: 8/1/2026, 11:13:27 PM
class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
               for ((i, element) in nums.withIndex()) {
        if (element == `val`) {
            nums[i] = -1
        }
    }

    var j: Int? = null
    var i = 0

    while (i < nums.size) {
        if (nums[i] == -1 && j == null) {
            j = i
        }

        if (nums[i] != -1 && j != null) {
            nums[j] = nums[i]
            nums[i] = -1
            i = j
            j = null
        }

        i++
    }

    return j ?: nums.size
    }
}