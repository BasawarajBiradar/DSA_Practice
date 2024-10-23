package dsaProblems.datastructures.arraylist;

public class Main {
    public static void main(String[] args) {
        CustomArrayList list = new CustomArrayList(4);
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(11);
        list.add(5, 10);
        list.add(4);
        list.add(5);
        list.printArray();
        list.delete(2);
        list.printArray();
        list.deleteByValue(5);
        list.printArray();
    }
}
