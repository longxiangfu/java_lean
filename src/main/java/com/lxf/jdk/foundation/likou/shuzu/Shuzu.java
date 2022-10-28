package com.lxf.jdk.foundation.likou.shuzu;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Shuzu {
    public int[] twoSum(int[] nums, int target) {
        int[] indexs = new int[2];

        // 建立k-v ，一一对应的哈希表
        HashMap<Integer,Integer> hash = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(hash.containsKey(nums[i])){
                indexs[0] = i;
                indexs[1] = hash.get(nums[i]);
                System.out.println(indexs[0]+"|"+indexs[1]);
                return indexs;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target-nums[i],i);
        }
        return indexs;
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] combineArr = new int[nums1.length + nums2.length];
        for(int i = 0; i<nums1.length; i++) {
            combineArr[i] = nums1[i];
        }
        for(int j = 0; j<nums2.length; j++) {
            combineArr[nums1.length+j] = nums2[j];
        }
        Arrays.sort(combineArr);
        if(combineArr.length%2 == 0) {
            // 偶数个元素
            return (combineArr[combineArr.length/2] + combineArr[combineArr.length/2-1])/2.0;
        }
        // 奇数个元素
        return combineArr[(combineArr.length-1)/2];
    }


    public static void main(String[] args) {
        Shuzu shuzu = new Shuzu();
//        shuzu.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(shuzu.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

}
