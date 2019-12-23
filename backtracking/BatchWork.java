public class BatchWork {
    int n=3;//作业数
    int[][] mission={{2,1},{3,1},{2,3}};//各作业所需要的时间，{2，1}表示作业1在机器1，2上的运行时间为2和1
    int bestFinishtime = Integer.MAX_VALUE;//最短时间
    int[] schedule = {0,1,2};//默认的策略顺序。
    int[] bestSchedule = new int[n];//最佳顺序
    int[] f2 = new int[n];//第二台机器的每个任务的结束时间
    int f1,totaltime;//f1当前任务的结束时间，f2的总时间
    public void swap(int[] str,int m,int n){
        int temp = str[m];
        str[m] = str[n];
        str[n] = temp;
    }
    
    //所有作业在机器2上完成处理的时间之和 f = sigma F[2][i] 称为该作业调度的完成时间之和。 
    public void BackTrack(int t){
        //得到一个最优解
        if(t>n-1){
            bestFinishtime = totaltime;//记录最佳执行时间
            for(int i=0;i<n;i++)
                bestSchedule[i] = schedule[i];//记录最优执行顺序
            return;
        }
 
        for(int i=t;i<n;i++){       //下面执行的是第t次的任务，全部遍历剩下的可能性。
            f1+=mission[schedule[i]][0];//前i个被调度的作业在机器1的处理时间总和
            if(t==0) {//遍历数的第一层
                f2[t]=f1+mission[schedule[i]][1];}
            else{
                f2[t] = ((f2[t-1]>f1)?f2[t-1]:f1)+mission[schedule[i]][1];
                }//第i个被调度的作业在第2个机器上完成处理时间
                totaltime += f2[t];//前i个被调度作业在第2个机器上完成处理的时间和
            //如果该作业处理完之后，总时间已经超过最优时间，就直接回溯。
            if(totaltime<bestFinishtime){//限界条件
                swap(schedule,t,i); //把选择出的原来在i位置上的任务序号调到当前执行的位置t
                BackTrack(t+1);
                swap(schedule,t,i);//进行回溯，还原，执行该层的下一个任务。
            }
            f1 -= mission[schedule[i]][0];
            totaltime -= f2[t];
        }
    }       
    public static void main(String[] args){
        test4 bs = new test4();
        bs.BackTrack(0);//从排列树第一层开始遍历
        System.out.println("最佳调度方案为:");
        for(int i=0;i<bs.n;i++){
            System.out.print(bs.bestSchedule[i]+"  ");
        }
        System.out.println();
        System.out.println("其完成时间为"+bs.bestFinishtime);
    }
}