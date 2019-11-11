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
        print(bst);
        print(bst.contains(3)); //false
        print(bst.contains(7)); //true
        print(bst.getMax()); //12
        print(bst.getMin()); //1
        print(bst.floor(10)); //9
        print(bst.floor(7)); //7
        print(bst.floor(0)); //null
        print(bst.ceiling(10));
        print(bst.ceiling(13)); //null
        print(bst.getKth(8));//12
        print(bst.getRank(12)); //8
    }

    public static void print(Object obj){
        System.out.println(obj);
        System.out.println("----");
    }
}