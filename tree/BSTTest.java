public class BSTTest{
    public static void main(String[] args) {
        BSTWithCount<Integer> bst=new BSTWithCount<>();
/*        bst.add(8);
        bst.add(3);
        bst.add(1);
        bst.add(6);
        bst.add(4);
        bst.add(7);
        bst.add(11);
        bst.add(9);
        bst.add(12);*/

/*        bst.add2(8);
        bst.add2(3);
        bst.add2(1);
        bst.add2(6);
        bst.add2(4);
        bst.add2(7);
        bst.add2(11);
        bst.add2(9);
        bst.add2(12);*/

        bst.addLoop(8);
        bst.addLoop(3);
        bst.addLoop(1);
        bst.addLoop(6);
        bst.addLoop(4);
        bst.addLoop(7);
        bst.addLoop(11);
        bst.addLoop(9);
        bst.addLoop(12);
        print(bst);
        print(bst.size()); //9
        print(bst.contains(13)); //false
        print(bst.contains(7)); //true
        print(bst.getMax()); //12
        print(bst.getMin()); //1
        print(bst.floor(10)); //9
        print(bst.floor(7)); //7
        print(bst.floor(0)); //null
        print(bst.ceiling(10)); //11
        print(bst.ceiling(13)); //null
        print(bst.getKth(8));//12
        print(bst.getRank(12)); //8
        //修改bst结构
        //bst.delete(3);
        print(bst);
    }

    public static void print(Object obj){
        System.out.println(obj);
        System.out.println("----");
    }
}