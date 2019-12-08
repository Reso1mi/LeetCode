public class Main11_10{
    public static void main(String[] args) {
        Main11_10 m=new Main11_10();
        /*["dog","cat","dad","good"]
        ["a","a","c","d","d","d","g","o","o"]
        [1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0]*/
        String[]str={"dog","cat","dad","good"};
        char[] letters={'a','a','c','d','d','d','g','o','o'};
        int[] score={1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(m.maxScoreWords(str,letters,score));
    }  

    //0 0 0  1 2 1
    //0 0 0  0 1 0
    //第一题
    public int oddCells(int n, int m, int[][] indices) {
        int[][] nums=new int[n][m];
        for (int i=0;i<indices.length;i++) {
            for (int j=0;j<m;j++) {
                nums[indices[i][0]][j]++;
            }

            for (int j=0;j<n;j++) {
                nums[j][indices[i][1]]++;
            }
        }
        int count=0;
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (nums[i][j]%2==1) {
                    count++;
                }
            }
        }
        return count;
    }


    //第三题
    private int[][] diretion={{0,1},{1,0},{0,-1},{-1,0}};

    public int closedIsland(int[][] grid) {
        boolean[][] visit=new boolean[grid.length][grid[0].length];
        for (int i=0;i<grid.length;i++) {
            if (grid[i][0]==0 && !visit[i][0]) {
                dfs1(grid,visit,i,0);   
            }
            if (grid[i][grid[0].length-1]==0 && !visit[i][grid[0].length-1]) {
                dfs1(grid,visit,i,grid[0].length-1);
            }
        }

        for (int i=0;i<grid[0].length;i++) {
            if (grid[0][i]==0 && !visit[0][i]) {
                dfs1(grid,visit,0,i);
            }
            if (grid[grid.length-1][i]==0 && !visit[grid.length-1][i]) {
                dfs1(grid,visit,grid.length-1,i);
            }
        }

        int count=0;
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {
                if (grid[i][j]==0 && !visit[i][j]) {
                    dfs2(grid,visit,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs2(int[][] grid,boolean[][] visit,int x,int y){
        visit[x][y]=true;
        for (int i=0;i<4;i++) {
            int nx=x+diretion[i][0];
            int ny=y+diretion[i][1];
            if (isValid(grid,nx,ny) &&!visit[nx][ny] && grid[nx][ny]==0) {
                dfs2(grid,visit,nx,ny);
            }
        }
    }

    public void dfs1(int[][] grid,boolean[][] visit,int x,int y){
        visit[x][y]=true;
        grid[x][y]=1;
        for (int i=0;i<diretion.length;i++) {
            int nx=x+diretion[i][0];
            int ny=y+diretion[i][1];
            if (isValid(grid,nx,ny) && !visit[nx][ny] && grid[nx][ny]==0) {
                dfs1(grid,visit,nx,ny);
            }
        }
    }

    public boolean isValid(int[][] grid,int x,int y){
        return x>=0 && x<grid.length && y>=0 && y<grid[0].length;
    }


/*    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int[][] nums=new int[colsum.length][2];

    }*/

    //第四题
    //背包问题
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] les=new int[26];
        for (int i=0;i<letters.length;i++) {
            les[letters[i]-'a']++;
        }
        return maxScoreWords(words,letters,score,0,les);
    }

    public int maxScoreWords(String[] words, char[] letters, int[] score,int index,int[] les) {
        if (index==words.length) {
            return 0;
        }
        int res=maxScoreWords(words,letters,score,index+1,les);
        String word=words[index];
        if (hasWord(les,word)) {
            int[] bak=new int[les.length];
            System.arraycopy(les,0,bak,0,les.length);
            res=Math.max(res,getScore(bak,word,score)+maxScoreWords(words,letters,score,index+1,bak));
        }
        return res;
    }

    public boolean hasWord(int[] les,String word){
        int[] bak=new int[les.length];
        System.arraycopy(les,0,bak,0,les.length);
        int count=0;
        for(char c:word.toCharArray()){
            if (bak[c-'a']!=0) {
                bak[c-'a']--;
                count++;
            }
        }
        return count==word.length();
    }   

    public int getScore(int[] les,String word,int[] score){
        int sc=0;
        for (char c:word.toCharArray()) {
            les[c-'a']--;
            sc+=score[c-'a'];
        }
        return sc;
    }

    public void printArray(int[] array){
        for (int i=0;i<array.length;i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}