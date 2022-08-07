package com.example.exercise.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers
 * such that they add up to target.
 */
public class TwoSumIndices {

    public static void main(String... args){
        int[] array = {3, 2, 4, 1, 7, 5, 11};
        int target = 9;
        int[] result = twoSum(array, target);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum1(int[] nums, int target) {
        int[] result = {};
        for(int i = 0 ; i < nums.length; i++){
            int aNum = nums[i];
            //Find other
            for(int j = i+1; j<nums.length ; j++){
                if((nums[i] + nums[j]) == target) {
                    result = new int[]{i, j};
                    break;
                }
            }
        }
        return result;
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            int requiredNum = target-nums[i];
            if(map.containsKey(requiredNum)){
                return new int[]{map.get(requiredNum), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
