package com.swimmingliu.arraysandstring;

/**
 * 27. 移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。
 * 元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。
 * 假设 nums 中不等于 val 的元素数量为 k，要通过此题，您需要执行以下操作：
 * 更改 nums 数组，使 nums 的前 k 个元素包含不等于 val 的元素。
 * nums 的其余元素和 nums 的大小并不重要。
 * 返回 k。
 */
public class Q27 {
    // 前后指针
    public static int removeElement(int[] nums, int val) {
        int front = 0, tail = 0;
        tail = findTail(nums, tail, val);
        front = tail + 1;
        while (front < nums.length) {
            if (nums[front] != val) {
                swap(nums, front, tail);
                // 找到下一个tail
                tail = findTail(nums, tail + 1, val);
            }
            front++;
        }
        return tail;
    }
    private static int findTail(int[] nums, int tail, int val) {
        while (tail < nums.length) {
            if (nums[tail] == val) return tail;
            else tail++;
        }
        return tail;
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 2, 3, 2};
        System.out.println(removeElement(nums1, 3));
    }
}
