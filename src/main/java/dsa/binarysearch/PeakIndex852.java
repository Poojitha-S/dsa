package dsa.binarysearch;

public class PeakIndex852 {

    public static void main(String[] args) {
        PeakIndex852 search = new PeakIndex852();
        int[] nums  = {0,10,11,5,2};
        int[] nums1  = {1,2,1,3,5,6,4};

        System.out.println("Brute Force : " + search.findPeakIndexBrute(nums)); // Output: 2
        System.out.println("BinarySearch : "+ search.findPeakIndexBinarySearch(nums1)); // Output: 5
    }
    public int findPeakIndexBrute(int[] nums) {
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++){
            if(nums[i] < max){
                max = nums[i];
            } else {
                max = i;
            }
        }
        return max;
    }

    public int findPeakIndexBinarySearch(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] > nums[mid + 1]){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
