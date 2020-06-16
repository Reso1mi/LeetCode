public class MinDays1482{
    public static void main(String[] args) {

    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        if(m*k>n) return -1; //花园的花不够
        //直接写就完事了，这里数据范围只到1e9，log(1e9)很小的，只有30左右
        int left=1,right=(int)1e9; 
        int res=right+1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(check(bloomDay,m,k,mid)){
                res=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return res;
    }
    
    public boolean check(int[] bloomDay,int m,int k,int day){
        int i=0;
        int count=0;
        int temp=0; //相邻的开花数量
        for(int d:bloomDay){
            if(d<=day){ //花开了(md，这个if写反两次)
                temp++;
            }else{
                temp=0;
            }
            if(temp==k){
                temp=0;
                count++;
            }
        }
        return count>=m;
    }

    //check写的好丑啊
    public boolean check(int[] bloomDay,int m,int k,int day){
        int i=0;
        int count=0;
        while(i<bloomDay.length){
            int temp=0;
            while(i<bloomDay.length){
                if(bloomDay[i]<=day){ //开始写反了。。。
                    temp++;
                    if(temp==k){
                        count++;
                        break;
                    }
                    i++;
                }else{
                    break;
                }
            }
            if(count>=m) return true;
            i++;
        }
        return false;
    }
}