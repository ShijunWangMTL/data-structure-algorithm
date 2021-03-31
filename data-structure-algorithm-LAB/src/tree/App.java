package tree;

public class App {
    public static void main(String[] args) {
        Tree intTree = new Tree();
        intTree.insert(12);
        intTree.insert(10);
        intTree.insert(25);
        intTree.insert(20);
        intTree.insert(11);
        intTree.insert(50);
        intTree.insert(8);
        intTree.insert(9);
        intTree.insert(5);

       // intTree.min();
        System.out.println(intTree.min());
//        intTree.max();
        System.out.println(intTree.max());
        //intTree.deleteNode(25);
       // System.out.println(intTree.get(12));
        intTree.traverseOrder(intTree.getRoot());
    }
}
