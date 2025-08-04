package dsa.binarysearch;

public class BinarySearch704 {
    public static void main(String[] args){
        BinarySearch704 binarySearch = new BinarySearch704();
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(binarySearch.searchBrute(nums,target));
        System.out.println(binarySearch.binarySearch(nums,12));
    }
    public int searchBrute(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                return i;
            }
        }
        return -1;
    }
    public int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
