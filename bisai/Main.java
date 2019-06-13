public class Main{
	
	public static void main(String[] args) {
		//int []nums={};
		//String text="thestoryofleetcodeandme";
		String text="baabaaaaaa";
		String[] words={"b","a","ba","bb","aa"};
		/*
		"baabaaaaaa"
		["b","a","ba","bb","aa"]
		 */
		//System.out.println(text.substring(0,1));
		//String[] words={"story","fleet","leetcode"};
		//workers = [[0,0],[1,1],[2,0]], bikes = [[1,0],[2,2],[2,1]]
		/*
		[[815,60],[638,626],[6,44],[103,90],[591,880]]
		[[709,161],[341,339],[755,955],[172,27],[433,489]]

		[[239,904],[191,103],[260,117],[86,78],[747,62]]
		[[660,8],[431,772],[78,576],[894,481],[451,730],[155,28]]

		 */
		
		int [][]workers={{239,904},{191,103},{260,117},{86,78},{747,62}};
		int [][]bikes={{660,8},{431,772},{78,576},{894,481},{451,730},{155,28}};
		System.out.println(assignBikes(workers,bikes));

	}


	public static int fixedPoint(int[] A) {
		if(A.length<=0){
			return -1;
		}
        for (int i=0;i<A.length;i++) {
        	if(A[i]==i){
        		return i;
        	}
        }
        return -1;
    }


    public static int[][] indexPairs(String text, String[] words) {
    		if(words==null||words.length<=0||text==null){
    			return null;
    		}
    		int [][]res=new int[10000][2];
    		int index=0;
    		text+="0";
     	   	for (int i=0;i<text.length();i++) {
     	   		for (int j=i;j<text.length();j++) {
     	   			//System.out.println(i+","+j);
     	   			if(isInWords(text.substring(i,j),words)){
     	   				res[index][0]=i;
     	   				res[index][1]=j-1;
     	   				index++;
     	   				//System.out.println(i+","+(j-1));
     	   			}
     	   		}
     	   }
     	   int [][]r=new int[index][2];
     	   for (int i=0;i<r.length;i++) {
     	   		r[i][0]=res[i][0];
     	   		r[i][1]=res[i][1];
     	   }
     	   return r;
    }

    public static boolean isInWords(String str,String []words){
    	for (int i=0;i<words.length;i++) {
    		if(str.equals(words[i])){
    			return true;
    		}
    	}
    	return false;
    }

    public static int assignBikes2(int[][] workers, int[][] bikes) {
    	int res=0;
        for (int i=0;i<workers.length;i++) {
        	int min=Integer.MAX_VALUE,temp=0;
        	for (int j=0;j<bikes.length;j++) {
        		if(bikes[j][0]==-1){
        			continue;
        		}
        		int man=manhadun(bikes[j][0],workers[i][0],bikes[j][1],workers[i][1]);
        		System.out.println(man+",");
        		if(man>=min){
        			continue;
        		}else{
        			min=man;
        			temp=j;
        		}
        	}
			bikes[temp][0]=-1;
        	res+=min;
        }
        return res;
    }


      public static int assignBikes(int[][] workers, int[][] bikes) {
    	int res=0;
        for (int i=0;i<bikes.length;i++) {
        	
        	int min=Integer.MAX_VALUE,temp=0;
        	for (int j=0;j<workers.length;j++) {
        		if(workers[j][0]==-1){
        			continue;
        		}
        		int man=manhadun(bikes[i][0],workers[j][0],bikes[i][1],workers[j][1]);
        		System.out.println(man+",");
        		if(man>=min){
        			continue;
        		}else{
        			min=man;
        			temp=j;
        		}
        		//System.out.println("min:" +min);
        	}
			workers[temp][0]=-1;
        	res+=min;
        	if(i==workers.length-1){
        		break;
        	}
        	//System.out.println(res);
        }
        return res;
    }

    public static int manhadun(int x1,int x2,int y1,int y2){
    	return Math.abs(x1-x2) + Math.abs(y1-y2);
    }

    public static int digitsCount(int d, int low, int high) {
    	int count=0;
        for (int i=low;i<=high;i+=d) {
        	String temp=String.valueOf(i);
        	count+=temp.length()-temp.replace(String.valueOf(d),"").length();	
        }
        return count;
    }
}