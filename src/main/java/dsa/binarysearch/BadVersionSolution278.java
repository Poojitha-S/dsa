package dsa.binarysearch;

public class BadVersionSolution278 extends VersionControl{
    public BadVersionSolution278(int bad) {
        super(bad);
    }
    public int firstBadVersionBrute(int n) {
        for (int i = 1; i <= n; i++) {
            if (isBadVersion(i)) {
                return i;
            }
        }
        return -1;
    }

    public int firstBadVersionBinarySearch(int n) {
        int low = 1, high = n, res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        BadVersionSolution278 sol = new BadVersionSolution278(4);
        System.out.println("Brute : " + sol.firstBadVersionBrute(10)); // Output: 4
        System.out.println("BS : "+sol.firstBadVersionBinarySearch(10)); // Output: 4
    }
}
