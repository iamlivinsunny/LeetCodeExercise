package leetcode;

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

//https://leetcode.com/problems/two-sum/
/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
 */
public class Exercise_001_TwoSum {

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] result = solution.twoSum(new int[]{1, 2, 3, 4}, 3);
        System.out.println(Arrays.toString(result));
    }

}

class Solution{
    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> numsMap = new HashMap<>();
        for(int i = 0; i < nums.length; i ++){
            if(numsMap.containsKey(target - nums[i]))
                return new int[]{numsMap.get(target-nums[i]), i};
            else
                numsMap.put(nums[i], i);
        }
        return new int[]{};
    }
}