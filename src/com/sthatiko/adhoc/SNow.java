package com.sthatiko.adhoc;

import java.util.HashSet;
import java.util.Set;

class SNow
{
    Set<Integer> hs = new HashSet<>();
    public static void main (String[] args) throws java.lang.Exception
    {
        SNow m = new SNow();
        int[] input = new int[]{-3,-2,-1,1,2,3,4, 5,6,7,8,10,11,54,76};
        System.out.println(m.findThreeSum(input, 10));
    }
    public boolean findThreeSum(int[] arr, int sum){
        boolean found = false;
        for(int i=0;i<arr.length;i++){
            if(hs.contains(arr[i])) continue;
            int twoSum = sum - arr[i];
            if(findTwoSum(arr, twoSum, i)){
                System.out.println(arr[i]);
                found = true;
            }
        }
        return found;
    }

    public boolean findTwoSum(int[] arr, int sum, int index){
        boolean found = false;
        if(arr.length == 0) return false;
        int left = 0, right = arr.length-1;
        while(left < right){
            if(left == index) {
                left++;
                continue;
            }else if (right == index){
                right--;
                continue;
            }
            int lsum = arr[left] + arr[right];
            if(lsum == sum){
                hs.add(arr[left]);
                hs.add(arr[right]);
                System.out.println(""+arr[left] + ", "+ arr[right]);
                found=true;
            }
            if(lsum>sum) right--;
            else left++;
        }
        return found;
    }
}
