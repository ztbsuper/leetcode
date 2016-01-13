package leetcode;


import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Leetcode268 {



    /*
    *  另数学解法:  求0,1...n的等差数列求和, 减去given数列和即可.
    * */
    @Test
    public void should_resolve_268() throws Exception {
        int[] given = new int[]{40, 43, 42, 18, 6, 13, 19, 8, 44, 4, 12, 22, 31, 30, 10, 16, 3, 17, 25, 7, 41, 21, 48, 26, 32, 27, 49, 15, 1, 20, 35, 46, 11, 23, 2, 0, 38, 28, 37, 9, 39, 47, 36, 45, 24, 34, 29, 14, 33};
        int expect = 5;
        assertThat(resolve_268_quick_xor(given), is(expect));

        int[] given2 = new int[]{1, 0};
        int expect2 = 2;
        assertThat(resolve_268_quick_xor(given2), is(expect2));

    }

    /*
    *  使用异或法, a^a=0, a^0=a, a^b^c=b^c^a
    *  利用题目 index = value 特性, 让每次迭代自行更替(无法越界),最后处理一个越界的index, 就只剩没有被自身替换的
    *
    * */
    private int resolve_268_quick_xor(int[] nums) {
        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }
        return xor ^ i;
    }

    /*
    *   先构建一个n长正整数数组, 接着按index替换为-1即可不用排序, 最后找出不为-1的一位即可
    * */
    private int resolve_268_quick(int[] nums) {
        int[] arr = buildArray(nums.length);
        wipeArray(arr, nums);
        return getTheMissingNumber(arr);
    }

    private int[] buildArray(int length) {
        int[] result = new int[length + 1];
        for (int i = 0; i <= length; i++) {
            result[i] = i;
        }
        return result;
    }

    private void wipeArray(int[] origin, int[] target) {
        for (int i : target) {
            origin[i] = -1;
        }
    }

    private int getTheMissingNumber(int[] wiped) {
        for (int i : wiped) {
            if (i != -1) {
                return i;
            }
        }
        return 0;
    }

    /*
    *   先快排,再二分
    * */
    private int resolve_268(int[] nums) {
        quick_sort_recursive(nums, 0, nums.length - 1);

        return resolve_268_private_func(nums, 0, nums.length - 1);
    }

    private int resolve_268_private_func(int[] input, int startIndex, int endIndex) {
        int startValue = input[startIndex];
        int endValue = input[endIndex];
        if (startValue != startIndex) {
            return startIndex;
        }
        if (endIndex != endValue && endIndex - 1 == input[endIndex - 1]) {
            return endIndex;
        }

        int midIndex = (startIndex + endIndex) / 2;
        if (input[midIndex] == midIndex) {
            return resolve_268_private_func(input, midIndex, endIndex);
        } else {
            return resolve_268_private_func(input, startIndex, midIndex);
        }
    }

    private void quick_sort_recursive(int[] arr, int start, int end) {
        if (start >= end)
            return;
        int mid = arr[end];
        int left = start, right = end - 1;
        while (left < right) {
            while (arr[left] < mid && left < right)
                left++;
            while (arr[right] >= mid && left < right)
                right--;
            swap(arr, left, right);
        }
        if (arr[left] >= arr[end])
            swap(arr, left, end);
        else
            left++;
        quick_sort_recursive(arr, start, left - 1);
        quick_sort_recursive(arr, left + 1, end);
    }


    private void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

}
