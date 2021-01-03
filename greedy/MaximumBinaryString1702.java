public class MaximumBinaryString {
    //100101100 --> 100000111
    //0000
    //首先1
    public String maximumBinaryString(String binary) {
        int n = binary.length();
        int cnt = 0;
        int i = 0;
        while (i < n && binary.charAt(i) == '1') i++;
        if (i==n) return binary;
        while (i < n) {
            if (binary.charAt(i) == '1') cnt++;
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n-cnt-1; j++) {
            sb.append("1");
        }
        sb.append("0");
        for (int j = 0; j < cnt; j++) {
            sb.append("1");
        }
        return sb.toString();
    }
}