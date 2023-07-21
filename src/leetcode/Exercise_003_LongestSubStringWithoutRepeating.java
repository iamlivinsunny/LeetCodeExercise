package leetcode;
//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
//Given a string s, find the length of the longest
//substring
// without repeating characters.

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;


public class Exercise_003_LongestSubStringWithoutRepeating {

    public static void main(String []args){
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.lengthOfLongestSubstring("abcabcbb"));
//        solution1.sumOfSubArray(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
//        solution1.shortestArray(new int[]{2, 3, 4, 2 }, 7);
    }
}




class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int l = 0;
        Set<Character> nonRepeatingChars = new HashSet<>();
        for(int r = 0; r < s.length(); r++){
            if(nonRepeatingChars.contains(s.charAt(r))){
                while(nonRepeatingChars.contains(s.charAt(r))){
                    nonRepeatingChars.remove(s.charAt(l));
                    l++;
                }
            }else{
                maxLength = Math.max(maxLength, r - l + 1);
            }
            nonRepeatingChars.add(s.charAt(r));
        }
        return maxLength;
    }

//    public int sumOfSubArray(int[] numbers, int groupCount){
//        int[] sumArray = new int[numbers.length - groupCount];
//        //left, right
//        int [] sub = Arrays.copyOfRange(numbers, 0, groupCount);
//        int sum = 0;
//        for(int num : sub)
//            sum += num;
//        sumArray[0] = sum;
//        for(int l=1; l < numbers.length - groupCount; l++){
//            sum += numbers[l + groupCount] - numbers[l];
//            sumArray[l] = sum;
//        }
//        System.out.println(Arrays.toString(sumArray));
//        return 0;
//    }

//    public int[] shortestArray(int[] numbers, int targetSum){
//
//        int[] subArray = numbers;
//        int sum = 0;
//
//        for(int i =0; i < numbers.length; i++){
//            sum+= numbers[i];
//        }
//        if(sum < targetSum)
//            return null;
//        else
//            sum=0;
//
//        int l=0;
//        for(int r=0; r < numbers.length; r++){
//            sum += numbers[r];
//            if(sum >= targetSum){
//                while(l < r){
//                    if(sum - numbers[l] >= targetSum){
//                        sum-= numbers[l];
//                        l++;
//                    }else
//                        break;
//                }
//                subArray = r + 1 - l  < subArray.length ?  Arrays.copyOfRange(numbers, l, r + 1) : subArray;
//            }
//        }
//        System.out.println(Arrays.toString(subArray));
//        return subArray;
//    }
}
