class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                shiftByOne(nums1, i);
                nums1[i] = nums2[j];
                j++;
                m++;
            } else {
                i++;
            }
        }

        while (j < n) {
            nums1[i++] = nums2[j++];
        }
    }

    public void shiftByOne(int[] nums1, int from) {
        for (int i = nums1.length - 1; i > from; i--) {
            nums1[i] = nums1[i - 1];
        }
    }
}