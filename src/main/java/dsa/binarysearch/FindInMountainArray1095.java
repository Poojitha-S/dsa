package dsa.binarysearch;

public class FindInMountainArray1095 {
    public static void main(String[] args) {
        int[] inputArr = {3,5,3,2,0};
        MountainArray mountainArr = new MountainArrayImpl(inputArr);
        FindInMountainArray1095 sol = new FindInMountainArray1095();

        int target = 3;
        int index = sol.findInMountainArray(target, mountainArr);

        System.out.println("Index of target " + target + ": " + index);// Expect 0

        target = 2;
        index = sol.findInMountainArray(target, mountainArr);
        System.out.println("Index of target " + target + ": " + index);// Expect 3

        target = 6;
        index = sol.findInMountainArray(target, mountainArr);
        System.out.println("Index of target " + target + ": " + index); // Expect -1
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();

        // Step 1: Find the peak index
        int peak = findPeakIndex(mountainArr, 0, n - 1);

        // Step 2: Search in ascending (left) part
        int leftRes = binarySearch(mountainArr, target, 0, peak, true);
        if (leftRes != -1) return leftRes;

        // Step 3: Search in descending (right) part
        return binarySearch(mountainArr, target, peak + 1, n - 1, false);
    }

    private int findPeakIndex(MountainArray arr, int low, int high) {
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid) < arr.get(mid + 1)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int binarySearch(MountainArray arr, int target, int low, int high, boolean ascending) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = arr.get(mid);
            if (val == target) return mid;

            if (ascending) {
                if (val < target) low = mid + 1;
                else high = mid - 1;
            } else {
                if (val > target) low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }
}
