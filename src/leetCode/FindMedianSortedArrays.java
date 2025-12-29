package leetCode;

//Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
//
//The overall run time complexity should be O(log (m+n)).
//Example 1:
//
//Input: nums1 = [1,3], nums2 = [2]
//Output: 2.00000
//Explanation: merged array = [1,2,3] and median is 2.
//Example 2:
//
//Input: nums1 = [1,2], nums2 = [3,4]
//Output: 2.50000
//Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
//
//
//Constraints:
//
//nums1.length == m
//nums2.length == n
//0 <= m <= 1000
//0 <= n <= 1000
//1 <= m + n <= 2000
//-106 <= nums1[i], nums2[i] <= 106

import java.util.Arrays;

public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l = ((nums1.length + nums2.length)/2)+1;
        if(l==1) return nums1.length > 0 ? nums1[0] : nums2[0];
        int[] answ = new int[l];
        for (int i = 0, q = 0, t = 0; i + q < l; t++) {
            if(nums2.length > q && (nums1.length == i || nums1[i] > nums2[q])) {
                answ[t] = nums2[q];
                q++;
            }else {
                answ[t] = nums1[i];
                i++;
            }
        }
        return (nums1.length + nums2.length) % 2 > 0 ? answ[l-1] : ((double) (answ[l-1] + answ[l-2]))/2.0;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
    }
}
