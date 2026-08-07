// Last updated: 8/7/2026, 11:12:48 AM
class Solution {
    
    private final Random rand = new java.security.SecureRandom();
    
    public int[] sortArray(int[] nums) {
        quickSort(nums);
        return nums;
    }

    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = rand.nextInt(right - left + 1) + left;

            if (pivot != right) {
                swap(arr, right, pivot);
            }

            int p = left;
            for (int i = left; i < right; i++) {
                if (arr[i] < arr[right]) {
                    swap(arr, p, i);
                    p++;
                }
            }

            swap(arr, p, right);

            quickSort(arr, left, p - 1);
            quickSort(arr, p + 1, right);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}