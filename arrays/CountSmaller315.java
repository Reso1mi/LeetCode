public class CountSmaller315{
    public static void main(String[] args) {

    }

    public List<Integer> countSmaller(int[] nums) {
        Pair[] pair=new Pair[nums.length];
        for(int i=0;i<nums.length;i++){
            pair[i]=new Pair(i,nums[i]);
        }
        int[] count=new int[nums.length];
        mergeSort(pair,0,nums.length-1,count);
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<count.length;i++){
            res.add(count[i]);
        }
        return res;
    }

    public void mergeSort(Pair[] nums,int left,int right,int[] count){
        if(left>=right){
            return;
        }
        int mid=left+(right-left)/2;
        mergeSort(nums,left,mid,count);
        mergeSort(nums,mid+1,right,count);
        merge(nums,left,mid,right,count);
    }

    public void merge(Pair [] nums,int left,int mid,int right,int[] count){
        int i=left,j=mid+1;
        //这里记得别用int[]
        Pair[] helper=new Pair[right-left+1];
        int index=0;
        while(i<=mid && j<=right){
            if(nums[i].value>nums[j].value){
                helper[index++]=nums[j++];
            }else{
                //i<=j 那么mid+1~j-1的肯定都比i小
                //(j-1)-(mid+1)+1=j-mid-1
                count[nums[i].index]+=j-mid-1;
                helper[index++]=nums[i++];
            }
        }
        while(i<=mid){
            //j没了，那么所有的j的元素都比i小
            //等价于right-mid
            count[nums[i].index]+=j-mid-1;
            helper[index++]=nums[i++];
        }
        while(j<=right){
            helper[index++]=nums[j++];
        }
        for(int k=0;k<helper.length;k++){
            nums[left+k]=helper[k];
        }
    }

    class Pair{
        int index;
        int value;
        public Pair(int i,int v){
            index=i;
            value=v;
        }
    }
}

/* golang写法
type Element struct{
    idx int
    val int
}

func countSmaller(nums []int) []int {
    n:=len(nums)
    count:=make([]int,n)
    elements:=make([]Element,n)
    for i,num:=range nums{
        elements[i].idx=i
        elements[i].val=num
    }
    mergeSort(elements,0,n-1,count)
    return count
}

func mergeSort(num []Element,left int,right int,count []int){
    if left>=right{
        return
    }
    mid:=left+(right-left)/2
    mergeSort(num,left,mid,count)
    mergeSort(num,mid+1,right,count)
    merge(num,left,mid,right,count)
}

func merge(num []Element,left int,mid int,right int,count []int){
    help:=make([]Element,right-left+1)
    i:=left
    j:=mid+1
    index:=0
    for i<=mid && j<=right {
        if num[i].val<=num[j].val{ //说明j前面的元素都小于i
            count[num[i].idx]+=(j-mid-1)
            help[index]=num[i]
            i++
        }else{
            help[index]=num[j]
            j++
        }
        index++
    }
    for i<=mid{
        count[num[i].idx]+=(j-mid-1)
        help[index]=num[i]
        index++
        i++
    }
    for j<=right{
        help[index]=num[j]
        index++
        j++
    }
    for i:=left;i<=right;i++{
        num[i]=help[i-left]
    }
}*/