public class NextGreatestLetter744{
    public static void main(String[] args) {

    }

    //按照新模板写的
    public char nextGreatestLetter(char[] letters, char target) {
        int left=0,right=letters.length-1;
        int res=0; //注意找不到的情况
        while(left<=right){
            int mid=(left+right)/2;
            if(letters[mid]>target){
                res=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return letters[res];
    }
}