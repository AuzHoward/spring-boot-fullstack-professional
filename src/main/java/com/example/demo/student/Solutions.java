package com.example.demo.student;

import com.example.demo.student.exception.BadRequestException;
import com.example.demo.student.exception.StudentNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.*;

@AllArgsConstructor
@Service
public class Solutions {

    public int[] twoSum(int[] nums, int target) {

        Arrays.sort(nums);
        int[] results = new int[2];

        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= target){
                break;
            }

            if(nums[i] + nums[i+1] == target) {
                results[0] = i;
                results[1] = i+1;
            }
        }
        return results;
    }

    public boolean isPalindrome(int x) {
        //if(x == 0){return false;}
        String str = Integer.toString(x);
        int beg = 0;
        int end = str.length()-1;
        boolean result = true;
        //char left;
        //char right;

        while(!(beg >= end)) {
            char left = str.charAt(beg);
            char right = str.charAt(end);
            if(left != right){
                result = false;
                break;
            }
            beg++;
            end--;

        }
        return result;
    }

    public int romanToInt(String s) {
        int length = s.length();
        if(s == null | length == 0) {return 0;}

        String roman = "IVXLCDM";
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put(roman.charAt(0), 1);
        map.put(roman.charAt(1), 5);
        map.put(roman.charAt(2), 10);
        map.put(roman.charAt(3), 50);
        map.put(roman.charAt(4), 100);
        map.put(roman.charAt(5), 500);
        map.put(roman.charAt(6), 1000);

        int sum = 0;
        for(int i = 0; i < length; i++) {
            sum += map.get(s.charAt(i));
            if(i < length-1 && map.get(s.charAt(i)) < map.get(s.charAt(i+1))) {
                sum -= map.get(s.charAt(i))*2;
            }
        }
        return sum;
    }

    public int maxSubArray(int[] nums) {

        int sum = 0;
        int max = nums[0];
        int ans = max;

        for(int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            max = Math.max(sum, nums[i]);
            if(max <= nums[i]) {
                sum = nums[i];
            }
            if(ans < max){
                ans = max;
            }
        }
        return ans;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        LinkedList<Integer> comb = new LinkedList<Integer>();
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(candidates);
        findAns(candidates, target, comb, ans, 0);
        return ans;
    }

    public void findAns(int[] candidates, int target, LinkedList<Integer> comb, List<List<Integer>> ans, int start){
        if(target < 0){
            return;
        }

        if(target == 0 && !ans.contains(comb)){
            ans.add(new ArrayList(comb));
        }

        for(int i = start; i < candidates.length; i++){
            comb.add(candidates[i]);
            findAns(candidates, target-candidates[i], comb, ans, i+1);
            comb.removeLast();
        }
    }

    public String longestCommonPrefix(String[] strs) {
        String word1 = strs[0];
        int length = word1.length();
        int min = length;


        for(int i = 1; i < strs.length; i++){
            int count = 0;
            String word2 = strs[i];
            int smallerWord = Math.min(length, word2.length());

            for(int j = 0; j < smallerWord; j++){
                if(word1.charAt(j) == word2.charAt(j)){
                    count++;
                }else{
                    break;
                }
            }
            min = Math.min(min, count);
            if(count == 0) {return "";}
        }

        String ans = word1.substring(0, min);
        return ans;
    }
}
