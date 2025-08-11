package dsa.binarysearch;

public class FindMinInRotatedSortedArray81 {

    public static void main(String[] args) {
        FindMinInRotatedSortedArray81 search = new FindMinInRotatedSortedArray81();
        int[] nums  = {4, 5, 6, 7, 0, 1, 2};
        int[] nums1  = {1,2,3,4,5};

        System.out.println("Brute Force : " + search.findMinBrute(nums1)); // Output: 0
        System.out.println("BinarySearch : "+ search.findMinBinarySearch(nums1)); // Output: 2
    }
    public int findMinBrute(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= nums.length - 1; i++){
            if(nums[i] < min){
                min = nums[i];
            }
        }
        return min;
    }

    public int findMinBinarySearch(int[] nums) {

        if (nums.length == 1 || nums[0] <= nums[nums.length - 1]) {
            return nums[0]; // Already sorted or single element
        }

        int low = 0, high = nums.length - 1;

        while (low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] > nums[high]){
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
}
