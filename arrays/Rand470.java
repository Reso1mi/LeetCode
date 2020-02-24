public class Rand470{
    public static void main(String[] args) {
        
    }

    public int rand10() {
        int a,b,idx;
        do{
            a=rand7();
            b=rand7();
            idx=a+(b-1)*7;
        }while(idx>40);
        return 1+(idx-1)%10;
    }
}