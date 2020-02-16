public class ProductOfNumbers5341{
    public static void main(String[] args) {
        
    }

    LinkedList<Integer> product=null;

    public ProductOfNumbers() {
        product=new LinkedList<>();
        product.add(1);
    }
    
    public void add(int num) {
        if(num==0){ //重新构建
            product=new LinkedList<>();
            product.add(1);
        }else{
            product.add(num*product.getLast());
        }
    }
    
    //1| 1 0 2 3  k=3
    public int getProduct(int k) {
        if(k>=product.size()){
            return 0;
        }
        return product.getLast()/product.get(product.size()-k-1);
    }
}