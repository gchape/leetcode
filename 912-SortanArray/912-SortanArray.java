// Last updated: 8/5/2026, 11:36:37 PM
1class Solution {
2    
3    private final Random rand = new java.security.SecureRandom();
4    
5    public int[] sortArray(int[] nums) {
6        quickSort(nums);
7        return nums;
8    }
9
10    public void quickSort(int[] arr) {
11        quickSort(arr, 0, arr.length - 1);
12    }
13
14    private void quickSort(int[] arr, int left, int right) {
15        if (left < right) {
16            int pivot = rand.nextInt(right - left + 1) + left;
17
18            if (pivot != right) {
19                swap(arr, right, pivot);
20            }
21
22            int p = left;
23            for (int i = left; i < right; i++) {
24                if (arr[i] < arr[right]) {
25                    swap(arr, p, i);
26                    p++;
27                }
28            }
29
30            swap(arr, p, right);
31
32            quickSort(arr, left, p - 1);
33            quickSort(arr, p + 1, right);
34        }
35    }
36
37    private void swap(int[] arr, int i, int j) {
38        int tmp = arr[i];
39        arr[i] = arr[j];
40        arr[j] = tmp;
41    }
42}