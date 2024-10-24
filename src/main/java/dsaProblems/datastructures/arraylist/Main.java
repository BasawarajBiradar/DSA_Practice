package dsaProblems.datastructures.arraylist;

public class Main {
    public static void main(String[] args) {
        CustomArrayList<Integer> list = new CustomArrayList<Integer>(4);
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
        list.delete(Integer.valueOf(5));
        list.printArray();
        CustomArrayList<String> stringList = new CustomArrayList<String>(3);
        stringList.add("one");
        stringList.printArray();
    }
}
