package dsa.binarysearch;

public class MountainArrayImpl implements MountainArray{
    private int[] arr;
    public MountainArrayImpl(int[] arr) { this.arr = arr; }
    public int get(int index) { return arr[index]; }
    public int length() { return arr.length; }
}
