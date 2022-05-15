package com.example.demo.student;

import com.example.demo.student.exception.BadRequestException;
import com.example.demo.student.exception.StudentNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class SolutionsTest {

    private Solutions underTest = new Solutions();

    @Test
    void canAddTwoSums() {
        //given
        int[] nums = new int[]{2,7,11,15};
        int target = 9;

        //when
        int[] actualArr = underTest.twoSum(nums, target);

        //then
        int[] expectedArr = new int[]{0,1};
        assertThat(actualArr).isEqualTo(expectedArr);
    }

    @Test
    void canCheckIfPalindromeIsTrue() {
        //given (parameter)
        int x = 121;

        //when
        boolean isPalindrome = underTest.isPalindrome(x);

        //then
        assertThat(isPalindrome).isTrue();
    }

    @Test
    void canCheckIfPalindromeIsFalse() {
        //given (parameter)
        int x = 122675657;

        //when
        boolean isPalindrome = underTest.isPalindrome(x);

        //then
        assertThat(isPalindrome).isFalse();
    }

    @Test
    void canSetRomanNumeralToInt(){
        //given
        String s = "LXI";

        //when
        int actual = underTest.romanToInt(s);

        //Then
        int expected = 61;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void canSetRomanNumeralToIntWhenUsingFour(){
        //given
        String s = "LIV";

        //when
        int actual = underTest.romanToInt(s);

        //Then
        int expected = 54;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void canFindMaxSubArray(){
        //given
        int[] array = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int expected = 6;

        //when
        int actual = underTest.maxSubArray(array);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void canFindCombination(){
        //given
        int[] array = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        //List<List<Integer>> expected = new ArrayList<>();//{{1,1,6},{1,2,5},{1,7},{2,6}};
        List<List<Integer>> expected = asList(
                asList(1,1,6),
                asList(1,2,5),
                asList(1,7),
                asList(2,6)
                );

        //when
        List<List<Integer>> actual = underTest.combinationSum2(array, target);

        //then
        assertThat(actual).isEqualTo(expected);
    }

}
