package com.swimmingliu.arraysandstring;

/**
 * 88. 合并两个有序数组
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，
 * 另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
 * 为了应对这种情况，nums1 的初始长度为 m + n，
 * 其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。
 * nums2 的长度为 n 。
 */
public class Q88 {
    // 空间换时间，辅助数组存nums1
//    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        int[] temp = new int[nums1.length];
//        int i = 0, j = 0, k = 0;
//        while(i < m && j < n){
//            if (nums1[i] < nums2[j])
//                temp[k ++] = nums1[i ++];
//            else
//                temp[k ++] = nums2[j ++];
//        }
//        while (i < m) temp[k ++] = nums1[i ++];
//        while (j < n) temp[k ++] = nums2[j ++];
//        for (int r = 0; r < nums1.length; r ++)
//            nums1[r] = temp[r];
//    }

    // 三指针：两个指针分别只想nums1和nums2，对应的真实末尾。另外一个指针，指向num1数组的最末尾
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = nums1.length - 1;
        while (i >= 0 && j >= 0){
            if (nums1[i] > nums2[j])
                nums1[k --] = nums1[i --];
            else
                nums1[k --] = nums2[j --];
        }
        // 补充剩余的部分
        while (i >= 0) nums1[k --] = nums1[i --];
        while (j >= 0) nums1[k --] = nums2[j --];
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
        for (int num : nums1) {
            System.out.println(num);
        }
    }
}
