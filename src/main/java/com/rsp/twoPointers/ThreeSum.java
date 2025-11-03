package com.rsp.twoPointers;

import java.util.*;

public class ThreeSum {
/*Given an integer array nums, find all unique triplets [nums[i], nums[j], nums[k]],
such that i ≠ j, i ≠ k, j ≠ k, and nums[i] + nums[j] + nums[k] == 0
.*/

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        int n = nums.length;

        for (int i = 0; i < n - 2; ++i) {
            if (nums[i] > 0)
                break;

            if (i == 0 || nums[i] != nums[i - 1]) {
                int low = i + 1, high = n - 1;

                while (low < high) {
                    int sum = nums[i] + nums[low] + nums[high];

                    if (sum < 0)
                        ++low;
                    else if (sum > 0)
                        --high;
                    else {
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));

                        ++low;
                        --high;
                        while (low < high && nums[low] == nums[low - 1])
                            ++low;
                        while (low < high && nums[high] == nums[high + 1])
                            --high;
                    }
                }
            }
        }

        return result;
    }

    // Driver code
    public static void main(String[] args) {
        int[][] numsArrs = {
                {-1, 0, 1, 2, -1, -4},
                {1, 2, 3, 4, 5},
                {0, 0, 0, 0},
                {-4, -1, -1, 0, 1, 2, 2},
                {-10, -7, -3, -1, 0, 3, 7, 10},
                {-3, -5, -7, -9}
        };

        for (int i = 0; i < numsArrs.length; i++) {
            int[] nums = numsArrs[i];
            System.out.println((i + 1) + ".\tnums: [" + Arrays.toString(nums));
            List<List<Integer>> result = threeSum(nums);
            System.out.print("\n\tTriplets: ");
            System.out.println(result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}
