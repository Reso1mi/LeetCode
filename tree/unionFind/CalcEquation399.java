import java.util.*;
public class CalcEquation399{
    public static void main(String[] args) {
        CalcEquation399 c=new CalcEquation399();
    }

    private HashMap<String,String> parent=new HashMap<>();

    private HashMap<String,Double> quotient=new HashMap<>();

    //不带路径压缩
    public String find(String p){
        while (parent.get(p)!=p) {
            p=parent.get(p);
        }
        return p;
    }

    public void init(String s){
        if (!parent.containsKey(s)) {
            parent.put(s,s);
            quotient.put(s,1.0);   
        }
    }

    public void merge(String a,String b,Double value){
        init(a);init(b);
        String fa=find(a); // a/fa=val[a], b/fb=val[b]
        String fb=find(b);
        if (fa.equals(fb)) {
            return;
        }
        parent.put(fa,fb);
        quotient.put(fa,value*(cal(b)/cal(a))); //cal(a)和cal(b)代表a和b到根节点的值
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i=0;i<equations.size();i++) {
            List<String> equation=equations.get(i);
            merge(equation.get(0),equation.get(1),values[i]);
        }
        double[] res=new double[queries.size()];
        int index=0;
        for (List<String> query:queries) {
            String a=find(query.get(0));
            String b=find(query.get(1));
            System.out.println(a+" "+b);
            if (!parent.containsKey(query.get(0)) || !parent.containsKey(query.get(1)) || !a.equals(b)) {
                res[index++]=-1;
            }else{
                //没有路劲压缩,需要遍历整个路劲求积
                res[index++]=cal(query.get(0))/cal(query.get(1));
            }
        }
        return res;
    }

    public double cal(String index){
        double res=quotient.get(index);
        while(parent.get(index)!=index){
            index=parent.get(index);
            res*=quotient.get(index);
        }
        return res;
    }


    private HashMap<String,String> parent=new HashMap<>();

    private HashMap<String,Double> quotient=new HashMap<>();

    //带路径压缩的
    public String find(String p){
        if (parent.get(p)!=p) {
            //需要先保存父亲的权值,因为后面压缩后树只有两层,后面*的就是根节点的权值1
            String f=parent.get(p); 
            parent.put(p,find(f));
            //这样压缩后的子节点才是正确的
            quotient.put(p,quotient.get(p)*quotient.get(f));
        }
        return parent.get(p);
    }

    public void init(String s){
        if (!parent.containsKey(s)) {
            parent.put(s,s);
            quotient.put(s,1.0);   
        }
    }

    public void merge(String a,String b,Double value){
        init(a);init(b);
        String fa=find(a); // a/fa=val[a], b/fb=val[b]
        String fb=find(b);
        if (fa.equals(fb)) {
            return;
        }
        parent.put(fa,fb);
        quotient.put(fa,value*(quotient.get(b)/quotient.get(a))); 
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i=0;i<equations.size();i++) {
            List<String> equation=equations.get(i);
            merge(equation.get(0),equation.get(1),values[i]);
        }
        double[] res=new double[queries.size()];
        int index=0;
        for (List<String> query:queries) {
            String a=query.get(0);
            String b=query.get(1);
            if (!parent.containsKey(a) || !parent.containsKey(b)) {
                res[index++]=-1;
            }else{
                //做路径压缩
                res[index++]=find(a).equals(find(b))?quotient.get(a)/quotient.get(b):-1;
            }
        }
        return res;
    }


    //构造图 + BFS/DFS
    private Map<String,Map<String,Double>> graph = new HashMap<>();

    public void buildGraph(List<List<String>> equations, double[] values){
        for (int i = 0; i < values.length; i++) {
            graph.computeIfAbsent(equations.get(i).get(0), k -> new HashMap<>()).put(equations.get(i).get(1), values[i]);
            graph.computeIfAbsent(equations.get(i).get(1), k -> new HashMap<>()).put(equations.get(i).get(0), 1 / values[i]);
        }
    }
    
    class Pair{
        String key;
        double val;
        public Pair(String key,double val){
            this.key=key;
            this.val=val;
        }
    }

    public double bfs(String a,String b){
        //讲道理,不管a,b是否在graph中,只要想等都应该返回1吧,这里是考虑了0的情况?
        if (!graph.containsKey(a) || !graph.containsKey(b)) {
            return -1.0;
        }
        if (a.equals(b)) {
            return 1.0;
        }
        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(a,1.0));
        HashSet<String> visit=new HashSet<>();
        while(!queue.isEmpty()){
            Pair cur=queue.poll();
            if (!visit.contains(cur.key)) {
                visit.add(cur.key);
                Map<String,Double> map=graph.get(cur.key);
                for (String next:map.keySet()) {
                    if (b.equals(next)) {
                        return cur.val*map.get(next);
                    }
                    queue.add(new Pair(next,cur.val*map.get(next)));
                }
            }
        }
        return -1.0;
    }

    public double dfs(String a,String b,HashSet<String> visit){
        if (!graph.containsKey(a)) {
            return -1;
        }
        if (a.equals(b)) {
            return 1;
        }
        visit.add(a);
        Map<String,Double> nextMap=graph.get(a);
        for (String next:nextMap.keySet()) {
            if (!visit.contains(next)) {
                double subres=dfs(next,b,visit);
                if (subres!=-1) {
                    return subres*nextMap.get(next);
                }
            }
        }
        return -1;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        buildGraph(equations,values);
        double[] res=new double[queries.size()];
        int index=0;
        for (List<String> query:queries) {
            HashSet<String> visit=new HashSet<>();
            //res[index++]=bfs(query.get(0),query.get(1),visit); 
            res[index++]=bfs(query.get(0),query.get(1));
        }
        return res;
    }
}