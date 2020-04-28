import java.util.*;
public class DiffWaysToCompute241{
    public static void main(String[] args) {
        DiffWaysToCompute241 d=new DiffWaysToCompute241();
        System.out.println(d.diffWaysToCompute("11*2+1"));
    }

    private Map<String,List<Integer>> map=new HashMap<>();

    //分治
    public List<Integer> diffWaysToCompute(String input) {
        if (input==null || input.length()<=0) {
            return new LinkedList<>();
        }
        return diffWaysToCompute(input,0,input.length()-1);
    }

    public List<Integer> diffWaysToCompute(String input,int left,int right) {
        List<Integer> res=new LinkedList<>();
        /*if (left==right) { //这一步可以去掉,最开始没考虑多位数的情况(考虑到了不知道怎么处理)
            res.add(Integer.valueOf(input.charAt(left))-48);
            return res;
        }*/
        String key=input.substring(left,right+1);
        if (map.containsKey(key)) {
            return map.get(key);
        }
        for (int i=left;i<=right;i++) { //大意了,这里一开始写成了input.length...
            char c=input.charAt(i);
            if (c<'0') {
                List<Integer> leftCompute=diffWaysToCompute(input,left,i-1);
                List<Integer> rightCompute=diffWaysToCompute(input,i+1,right);
                for (int lc:leftCompute) {
                    for (int rc:rightCompute) {
                        if (c=='+') 
                            res.add(lc+rc);
                        if (c=='-') 
                            res.add(lc-rc);
                        if (c=='*') 
                            res.add(lc*rc);
                    }
                }
            }
        }
        if (res.isEmpty()) {
            res.add(Integer.valueOf(key));
        }
        map.put(key,res);
        return res;
    }
}

/* golang解法
func diffWaysToCompute(input string) []int {
    var res []int
    if len(input)==0{
        return res
    }
    flag:=true //用res的长度判断就可以了
    for i:=0;i<len(input);i++{
        if input[i] < '0' {
            flag=false
            left:=diffWaysToCompute(input[:i])
            right:=diffWaysToCompute(input[i+1:])
            for _,le:=range left{
                for _,ri:=range right{
                    if input[i]=='+'{
                        res=append(res,le+ri)
                    }
                    if input[i]=='-'{
                        res=append(res,le-ri)
                    }
                    if input[i]=='*'{
                        res=append(res,le*ri)
                    }
                    if input[i]=='/'{
                        res=append(res,le/ri)
                    }
                }
            }
        }
    }
    if flag{
        res=append(res,string2int(input))
    }
    return res
}

func string2int(str string) int {
    res := 0
    temp := 1
    for i := len(str) - 1; i >= 0; i-- {
        res += int(str[i]-'0') * temp
        temp *= 10
    }
    return res
}
 */