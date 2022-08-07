package com.example.exercise.arrays;

import java.util.Arrays;

/**
 * you need to return the numbers whose sum is equal to the given number.
 * Need to return numbers instead of their indexes
 */
public class TwoSumNumbers {
    public static void main(String... args){
        int[] array = {3, 2, 4, 1, 7, 5, 11, 6, 8};
        int target = 9;
        int[] result = twoSum(array, target);
        System.out.println(Arrays.toString(result));
    }
    //Time complexity: O(n*log(n))
    public static int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int low =0;
        int high = nums.length -1;
        while(low<high){
            int tempSum = nums[low] + nums[high];
            if(tempSum == target){
                return new int[]{nums[low], nums[high]};
            } else if(tempSum < target){
                low++;
            } else {
                high--;
            }
        }
        return null;
    }
}
