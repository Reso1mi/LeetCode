public class MinNumberJZ_45{
    public static void main(String[] args) {

    }

    public String minNumber(int[] nums) {
        String[] strs=new String[nums.length];
        for(int i=0;i<nums.length;i++) strs[i]=nums[i]+"";
        Arrays.sort(strs,(a,b)->(a+b).compareTo(b+a));
        StringBuilder sb=new StringBuilder();
        for(String i:strs) sb.append(i);
        return sb.toString();
    }
}