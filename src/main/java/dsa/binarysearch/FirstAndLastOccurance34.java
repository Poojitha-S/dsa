package dsa.binarysearch;

public class FirstAndLastOccurance34 {
    public static void main(String[] args){
        FirstAndLastOccurance34 firstAndLastOccurance = new FirstAndLastOccurance34();
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] res1 = firstAndLastOccurance.firstAndLastOccuranceBrute(nums,target);
        for (int i = 0; i <= res1.length - 1; i++){
            System.out.println(res1[i]);
        }
        int[] res2 = firstAndLastOccurance.firstAndLastOccuranceBinarySearch(nums,target);
        for (int i = 0; i <= res2.length - 1; i++){
            System.out.println(res2[i]);
        }
    }
    public int[] firstAndLastOccuranceBrute(int[] nums, int target) {
        int first = -1, last = -1;
        for (int i = 0; i <= nums.length - 1; i++){
            if (nums[i]==target){
                if (first == -1)// First time we see the target
                    first = i;
                last = i;// Keep updating last every time we see the target
            }
        }
        return new int[]{first,last};
    }
    public int[] firstAndLastOccuranceBinarySearch(int[] nums, int target) {
        return new int[]{findBound(nums,target,true),findBound(nums,target,false)};
    }

    private int findBound(int[] nums, int target, boolean isFirst){
        int low = 0, high = nums.length -1, res = -1;
        while (low <= high){
            int mid = low + (high - low)/2;
            if (nums[mid] == target){
                res = mid;
                if (isFirst){
                    high = mid - 1; // keep searching left
                } else {
                    low = mid + 1; // keep searching right
                }
            } else if (nums[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
}
    