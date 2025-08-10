package dsa.binarysearch;

public class SearchInRotatedSortedArray33 {

    public static void main(String[] args) {
        SearchInRotatedSortedArray33 search = new SearchInRotatedSortedArray33();
        int[] nums  = {4, 5, 6, 7, 0, 1, 2};
        int target = 6;

        System.out.println("Brute Force : " + search.searchBrute(nums, target)); // Output: 2
        System.out.println("BinarySearch : "+ search.searchBinarySearch(nums, target)); // Output: 2
    }
    public int searchBrute(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                return i;
            }
        }
        return -1;
    }

    public int searchBinarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[low] <= nums[mid]){ // left part sorted
                if(nums[low] <= target && target < nums[mid]){// is target in left half part
                    high = mid - 1;
                } else {// is target in right half part
                    low = mid + 1;
                }
            } else {// right part sorted
                if(nums[mid] < target && target <= nums[high]){// is target in right half part
                    low = mid + 1;
                } else {// is target in left half part
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
