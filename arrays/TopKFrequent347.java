import java.util.*;
public class TopKFrequent347{

    public static void main(String[] args) {
        int []nums={1,2};
        System.out.println(topKFrequent(nums,2));
    }

    //topk 的高频元素
    public static List<Integer> topKFrequent(int[] nums, int k) {
        if(nums==null||nums.length<=0){
            return null;
        }
        HashMap<Integer,Integer> fre=new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            //fre.get(i) nums[i]出现的频次
            fre.put(nums[i],fre.getOrDefault(nums[i],0)+1);
        }
        ArrayList<Integer> [] bucket=new ArrayList[nums.length+1];
        for (Integer num:fre.keySet()) {
            if(bucket[fre.get(num)]==null){
                bucket[fre.get(num)]=new ArrayList<>();
            }
            bucket[fre.get(num)].add(num); //所有出现fre.get(num)次的元素
        }
        ArrayList<Integer> res=new ArrayList<>();
        int topk=bucket.length-1;
        while (true) {
            while(bucket[topk]==null&&topk>0){
                topk--;
            }
            res.addAll(bucket[topk--]);
            if(res.size()==k){
                return res;
            }
        }
    }

    //优雅的解法
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0)+1);
        }
        //int[0]: count int[1]: val 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[0]-b[0]);
        //freq.forEach();
        for (int key : freq.keySet()) {
            pq.offer(new int[]{freq.get(key), key});
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] res = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            res[i++] = pq.poll()[1];
        }
        return res;
    }


    //很就之前瞎写的，不优雅，笔试不太可能写出来
    public static List<Integer> topKFrequent2(int[] nums, int k) {
        if(nums==null||nums.length<=0){
            return null;
        }
        HashMap<Integer,Integer> fre=new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            //fre.get(i) nums[i]出现的频次
            fre.put(nums[i],fre.getOrDefault(nums[i],0)+1);
        }
        //1:3,2:3,3:1
        PriorityQueue<HashMap.Entry<Integer,Integer>> pq=new PriorityQueue<>((o1,o2)->o1.getValue()-o2.getValue());
        //维护k小根堆
        for (HashMap.Entry ent:fre.entrySet()) {
            pq.add(ent);
            if(pq.size()>k){
                pq.poll();
            }
        }
        ArrayList<Integer> res=new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll().getKey());
        }
        return res;
    }

    static class ComparatorMap implements Comparator<HashMap.Entry<Integer,Integer>>{
        @Override
        public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
            return o1.getValue()-o2.getValue();
        }
    }

    public static void printArray(ArrayList [] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}