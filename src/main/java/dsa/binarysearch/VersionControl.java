package dsa.binarysearch;

public class VersionControl {
    private int bad;
    public VersionControl(int bad){
        this.bad = bad;
    }

    public boolean isBadVersion(int version){
        return version >= bad;
    }
}
