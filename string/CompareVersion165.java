public class CompareVersion165{

    public static void main(String[] args) {
        CompareVersion165 c=new CompareVersion165();
        c.compareVersion("1.0.1","1");
    }

    public int compareVersion(String version1, String version2) {
        String[] v1=version1.split("\\.");
        String[] v2=version2.split("\\.");
        int len1=v1.length,len2=v2.length;
        int i=0,j=0;
        while(i<len1 || j<len2) {
            int a=Integer.valueOf(i<len1?v1[i++]:"0");
            int b=Integer.valueOf(j<len2?v2[j++]:"0");
            if (a<b) {
                return -1;
            }else if (a>b){
                return 1;
            }
        }
        return 0;
    }
}