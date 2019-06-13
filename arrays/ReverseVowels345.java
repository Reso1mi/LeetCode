public class ReverseVowels345{
	
	public static void main(String[] args) {
		String res=new ReverseVowels345().reverseVowels("hello");
		System.out.println(res);
	}


	public String reverseVowels(String s) {
		if(s==null||s.length()<=0){
			return s;
		}
		char[] ss=s.toCharArray();
		int left=0,right=s.length()-1;
		while(left<right){
			System.out.println(left+","+right);
			while(left<right && !isYy(ss[left])){
				left++;
			}
			while(left<right && !isYy(ss[right])){
				right--;
			}
			swap(left++,right--,ss);
		}
		return new String(ss);
	}

	public boolean isYy(char ch){
		char temp=Character.toLowerCase(ch);
		return temp=='a'|| temp=='e'||temp=='i'||temp=='o'||temp=='u';
	}

	public void swap(int a,int b,char[] s){
		char temp=s[a];
		s[a]=s[b];
		s[b]=temp;
	}
}