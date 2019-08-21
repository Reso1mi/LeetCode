public class KthGrammar779{

    public static void main(String[] args) {
        System.out.println(kthGrammar3(7,9));
    }

    /*
      第一行: 0
      第二行: 01
      第三行: 01|10
      第四行: 01 10|10 01
      第五行: 01 10 10 01|10 01 01 10
      第六行: 01 10 10 01 10 01 01 10 | 10 01 01 10 01 10 10 01
      N%2!=0 对称, 第K个等于 2^(N-1)-K+1
      N%2==0 互补对称
    */
    public static int kthGrammar(int N, int K) {
        if(K==1 || N==1){
            return 0;
        }
        if(K==2){
            return 1;
        }
        int len=1<<N-1;
        if(K>len/2){
            if(N%2!=0){
                K=len-K+1;
            }else{
                if(K%2==0){
                  K=len-K+2;  
                }else{
                  K=len-K;
                }
            }
        }
        return kthGrammar(N-1,K);
    }

    //满二叉树解法
    public static int kthGrammar2(int N, int K) {
        if (K==1) return 0;
        //(K+1)/2是对应父节点的index
        int parent=kthGrammar2(N-1,(K+1)/2);
        int f_parent=-(parent-1);
        if (K%2==0) {
            return f_parent;
        }
        return parent;
    }

    //不要N的解法
    public static int kthGrammar3(int N, int K) {
        boolean r=false;
        while(K>1){
            if (K%2==0) {
                K=K/2;
                r=!r;
            }else{
                K=(K+1)/2;
            }
        }
        return r?1:0;
    }
}