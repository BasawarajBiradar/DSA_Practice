package dsaProblems.datastructures.arraylist;
/**
 * Modification History
 * Name : Basawaraj Biradar
 *
 * Version   Date        Name                Changes
 * 1.0.0     22/10/2024  Basawaraj Biradar   Created file, Added int array, index in instance and created add(), print() methods.
 * 1.0.1     23/20/2024  Basawaraj Biradar   Created add(index, value), delete(index) and deleteByValue(value) methods.
 * 1.0.2     24/10/2024  Basawaraj Biradar   Added generic to the CustomArrayList class and updated all the methods.
 * */

public class CustomArrayList<k> {
    /** Create an array with initial size using constructor */
    private k[] arr;

    @SuppressWarnings("unchecked")
    public CustomArrayList() {
        arr = (k[]) new Object[5];
    }
    @SuppressWarnings("unchecked")
    public CustomArrayList(int size) {
        arr = (k[]) new Object[size];
    }

    /** Declare an instance variable to track the index */
    private int index = 0;

    /** Create add method
     *  it should first check if index is greater, then the size
     *  if false then add the value without any modification
     *  if not then create new array with larger size and add all the elements from old array and then new element
     * */
    @SuppressWarnings("unchecked")
    public boolean add(k value) {
        try {
            if (index < arr.length) {
                arr[index] = value;
                index++;
                return true;
            } else {
                k[] newArr = (k[]) new Object[arr.length + (arr.length/2)];
                for (int i = 0 ; i < arr.length ; i++) {
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

    /** Adding element at particular index
     * first check if given index is less then the instance index and given index is positive
     * check if the instance index is less then the length of array (but this may cause problem in extreme case so check for length-1)
     * iterate the instance array in reverse and shift each element back until we get to specified index and add that element there
     * increment the instance index because we shifted elements by one place.
     * in the else part of checking instance index and length of array increase the size of array and call the add(index, value) method.
     * */
    @SuppressWarnings("unchecked")
    public boolean add(int index, k value) {
        if (index > this.index)
            throw new ArrayIndexOutOfBoundsException();
        if (index < 0)
            throw new RuntimeException("index cannot be negative");
        try {
            if (this.index < arr.length-1) {
                for (int i = this.index ; i >= 0 ; i--) {
                    arr[i+1] = arr[i];
                    if(index == i) {
                        arr[i] = value;
                        this.index++;
                        return true;
                    }
                }
            } else {
                k[] newArr = (k[]) new Object[arr.length + (arr.length/2)];
                for (int i = 0 ; i < arr.length ; i++) {
                    newArr[i] = arr[i];
                }
                arr = newArr;
                this.add(index, value);
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return false;
    }

    /** Deleting an element at particular index
     * check if given index is less then or equal to this.index because we increment this.index after we have added so this.index is always greater than the number of elements by one
     * start the loop from index till this.index-1 and shift each element one position to front and index--
     * */
    public boolean delete(int index) {
        if(index >= this.index)
            throw new ArrayIndexOutOfBoundsException();
        if (index < 0)
            throw new RuntimeException("index cannot be negative");
        try {
            for (int j = index ;  j < this.index; j++) {
                arr[j] = arr[j+1];
            }
            this.index--;
            return true;
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return false;
    }

    /** Deleting the given element */
    public boolean delete(k value) {
        try {
            for (int i = 0 ; i < index ; i++) {
                if (arr[i].equals(value)) {
                    for (int j = i ; j < index ; j++) {
                        arr[j] = arr[j+1];
                    }
                    index--;
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return false;
    }

    /** Printing the array using for loop */
    public void printArray() {
        for (int i = 0 ; i< index ; i++) {
            System.out.print(arr[i] +" ");
        }
        System.out.println();
    }
}
