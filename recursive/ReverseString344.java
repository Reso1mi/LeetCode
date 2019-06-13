public class ReverseString344{
	public static void main(String[] args) {
		char []s={'h','e','l','l','o'};
		new ReverseString344().reverseString(s);
	}

	public void reverseString(char[] s) {
        reverseString(s,0,s.length-1);
    }
    
    public void reverseString(char[] s,int l,int r) {
        if(l==r-1 || l==r){
            return;
        }
        char temp=s[l];
        s[l]=s[r];
        s[r]=temp;
        reverseString(s,++l,--r);
    }
}