public class BSTTest{
    public static void main(String[] args) {
        BST<Integer> bst=new BST<>();
        bst.add(8);
        bst.add(3);
        bst.add(1);
        bst.add(6);
        bst.add(4);
        bst.add(7);
        bst.add(11);
        bst.add(9);
        bst.add(12);
        bst.add(7);
        System.out.println(bst);
        System.out.println(bst.contains(3)); //false
        System.out.println(bst.contains(7)); //true
    }
}