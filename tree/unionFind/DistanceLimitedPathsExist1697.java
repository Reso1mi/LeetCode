import java.io.*;
import java.util.*;
public class DistanceLimitedPathsExist1697 {

    public static void main(String[] args) {

    }

    int[] parent;

    public int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    public void union(int a,int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) return;
        parent[pa] = pb; 
    }

    //对查询的limit和边权值进行排序，然后我们从小query的limit开始，将edge权值不大于limit的都丢到并查集里面，然后查询一下就行了
    public boolean[] distanceLimitedPathsExist(int n, int[][] edge, int[][] q) {
        parent = new int[n];
        int qlen = q.length;
        for (int i = 0; i < n; i++) parent[i] = i;
        boolean[] res = new boolean[qlen];
        //记录query排序后的id
        Integer[] qid = new Integer[qlen];
        for (int i = 0; i < qlen; i++) qid[i] = i;
        Arrays.sort(edge, (e1, e2)->e1[2]-e2[2]);
        Arrays.sort(qid, (i1, i2)->q[i1][2]-q[i2][2]);
        int j = 0;
        for (int i = 0; i < qlen; i++) {
            while (j < edge.length && edge[j][2] < q[qid[i]][2]) {
                union(edge[j][0], edge[j][1]);
                j++;
            }
            res[qid[i]] = find(q[qid[i]][0]) == find(q[qid[i]][1]);
        }
        return res;
    }
}