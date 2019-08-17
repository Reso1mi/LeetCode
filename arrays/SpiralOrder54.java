import java.util.*;
public class SpiralOrder54{
    public static void main(String[] args) {
        //1  2  3  4
        //5  6  7  8
        //9  10 11 12
        //13 14 15 16
        //
        //1 2 3
        //4 5 6
        //7 8 9
        int [][] nums={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int [][] nums2={{1,2,3},{4,5,6},{7,8,9}};
        int [][] nums3={{1,2,3,4,5},{6,7,8,9,10}};
        //[[1,11],[2,12],[3,13],[4,14],[5,15],[6,16],[7,17],[8,18],[9,19],[10,20]]
        int [][] nums4={{1,11},{2,12},{3,13},{4,14},{5,15},{6,16},{7,17},{8,18},{9,19},{10,20}};
        System.out.println(spiralOrder2(nums3));
    }


    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();
        int a=matrix[0].length-1; //4
        int b=matrix.length-1;    //1
        while(true) {
            int m=matrix[0].length-1-a;
            int n=matrix.length-1-b;
            while(m<a){
                res.add(matrix[n][m++]);
            }

            while(n<b){
                res.add(matrix[n++][m]);
            }

            while(m>matrix[0].length-1-a){
                res.add(matrix[n][m--]);
            }
            
            while(n>matrix.length-1-b){
                res.add(matrix[n--][m]);
            }
            b--;
            a--;

            if(Math.max(a,b)==0){
                break;
            }
        }
        return res;
    }
    
    //1 2 3
    //4 5 6
    //7 8 9
    public static List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> res=new ArrayList<>();
        if(matrix.length<=0){
            return res;
        }
        //a: 行
        //b: 列
        int la=0,lb=0,ra=matrix.length-1,rb=matrix[0].length-1;
        while(lb<=rb && la<=ra){
            int tla=la,tlb=lb,tra=ra,trb=rb;
            if(tla==tra){
                while(tlb<=trb){
                    res.add(matrix[tla][tlb++]);
                }
                return res;
            }else if(tlb==trb){
                while(tla<=tra){
                    res.add(matrix[tla++][tlb]);
                }
                return res;
            }else{
                while(tlb<rb){
                    res.add(matrix[la][tlb++]);
                }
                //System.out.println(rb+","+tlb);
                while(tla<ra){
                    res.add(matrix[tla++][tlb]);
                }
                
                while(trb>lb){
                    res.add(matrix[ra][trb--]);
                }

                while(tra>la){
                    res.add(matrix[tra--][trb]);
                }
            }
            //向内靠拢(缩圈)
            la++;
            lb++;
            ra--;
            rb--;
        }
        return res;
    }
    
}