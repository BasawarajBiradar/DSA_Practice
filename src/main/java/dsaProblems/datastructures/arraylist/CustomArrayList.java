package dsaProblems.datastructures.arraylist;

public class CustomArrayList {
    /** create an array with initial size using constructor */
    private int[] arr;

    public CustomArrayList() {
        arr = new int[5];
    }
    public CustomArrayList(int size) {
        arr = new int[size];
    }

    /** Declare an instance variable to track the index */
    private int index = 0;

    /**
     *  Create add method
     *  it should first check if index is greater, then the size
     *  if false then add the value without any modification
     *  if not then create new array with larger size and add all the elements from old array and then new element
     * */
    public boolean add(int value) {
        try {
            if (index < arr.length) {
                arr[index] = value;
                index++;
                return true;
            } else {
                int[] newArr = new int[arr.length + (arr.length/2)];
                for (int i =0 ; i< arr.length; i++) {
                    newArr[i] = arr[i];
                }
                arr = newArr;
                add(value);
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return false;
    }

    /** printing the array using for loop */
    public void printArray() {
        for (int i = 0; i< index; i++) {
            System.out.print(arr[i] +" ");
        }
    }
}
