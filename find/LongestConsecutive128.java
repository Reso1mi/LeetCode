import java.util.*;
public class LongestConsecutive128{
    public static void main(String[] args) {

    }

    public int longestConsecutive(int[] nums) {
        if (nums ==null || nums.length<=0) {
            return 0;
        }
        HashSet<Integer> set=new HashSet();
        for (int n:nums) {
            set.add(n);
        }
        int max=0;
        for (int i=0;i<nums.length;i++) {
            int num=nums[i];
            if (!set.contains(num-1)) {
                int res=1;
                while(set.contains(num+1)){
                    res++;
                    num++;
                }
                max=Math.max(max,res);
            }
        }
        return max;
    }

    //暴力能过,但是不符合题目要求
    public int longestConsecutive(int[] nums) {
        if (nums ==null || nums.length<=0) {
            return 0;
        }
        HashSet<Integer> set=new HashSet();
        for (int n:nums) {
            set.add(n);
        }
        int max=0;
        for (int i=0;i<nums.length;i++) {
            int num=nums[i];
            int res=1;
            while(set.contains(num+1)){
                res++;
                num++;
            }
            max=Math.max(max,res);
        }
        return max;
    }

    //并查集
    HashMap<Integer,Integer> parent;
    
    HashMap<Integer,Integer> size;

    int max=1;

    public int find(int index){
        while(parent.get(index)!=index){
            //parent[index]=parent[parent[index]];
            parent.put(index,parent.get(index));
            index=parent.get(index);
        }
        return index;
    }

    public void union(int p,int q){
        int pID=find(p);
        int qID=find(q);
        if (pID==qID) {
            return;
        }
        int pSize=size.get(pID);
        int qSize=size.get(qID);
        if (pSize > qSize) {
            //parent[qID]=pID;
            parent.put(qID,pID);
            //size[pID]+=size[qID];
            size.put(pID,pSize+qSize);
        }else{
            //parent[pID]=qID;
            parent.put(pID,qID);
            //size[qID]+=size[pID];
            size.put(qID,pSize+qSize);
        }
        max=Math.max(max,pSize+qSize);
    }

    public void initUnionFind(int[]nums){
        parent=new HashMap<>();
        size=new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            parent.put(nums[i],nums[i]);
            size.put(nums[i],1);
        }
    }

    public int longestConsecutive(int[] nums) {
        if (nums ==null || nums.length<=0) {
            return 0;
        }
        HashSet<Integer> set=new HashSet();
        for (int i=0;i<nums.length;i++) {
            set.add(nums[i]);
        }
        initUnionFind(nums);
        for (int i=0;i<nums.length;i++) {
            if (set.contains(nums[i]-1)) {
                union(nums[i],nums[i]-1);
            }
        }
        return max;
    }
}