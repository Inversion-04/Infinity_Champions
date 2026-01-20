import java.util.*;

public class first_missing_positive {

    // Optimized (Cyclic Sort)
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static int firstMissingPositiveOptimized(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                int idx = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
            }
        }

        for (int j = 0; j < n; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }
        return n + 1;
    }

    // Brute Force (Sorting)
    // Time Complexity: O(n log n)
    // Space Complexity: O(1)
    public static int firstMissingPositiveBrute(int[] nums) {
        Arrays.sort(nums);
        int x = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                x++;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 4, -1, 1};
        int[] arr2 = {3, 4, -1, 1};

        System.out.println("Brute Answer: " + firstMissingPositiveBrute(arr1));
        System.out.println("Optimized Answer: " + firstMissingPositiveOptimized(arr2));
    }
}
