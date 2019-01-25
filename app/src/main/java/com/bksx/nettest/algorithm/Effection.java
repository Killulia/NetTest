package com.bksx.nettest.algorithm;

import android.util.Log;

public class Effection {

    public static final String TAG = "ccg";

    /*
    冒泡排序
     */

    public static void bubbleSort(int[] nums){
        //外层控制循环的次数即从第一个数比到最后一个数这样的操作进行多少次，内层循环控制从第一个数比到最后一个数
        //走一次
        boolean isSwitch;
        for (int i=0; i<nums.length-1; i++ ){
            isSwitch = false;
            Log.d(TAG, "i: "+i);
            for (int j=0; j<nums.length-1;j++){
                int temp;
                if (nums[j]>nums[j+1]){
                    temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    isSwitch = true;
                }

            }
            if (!isSwitch){
                break;
            }
        }

        for (int num : nums) {
            Log.d(TAG, "item: "+num);
        }

    }

     /*
    二分查找
     */
     public static int binarySerach(int[] array, int key){
         int result = -1;
         int left = 0;
         int right = array.length - 1;
         int mid;
         while (left <= right){

             mid = (left + right) / 2;
             if (array[mid] == key){
                 result = mid;
                 Log.d(TAG, "result: "+result);
                 return result;
             }else if (array[mid] < key){
                 left = mid + 1;
             }else {
                 right = mid - 1;
             }
         }

         return result;

     }
}
