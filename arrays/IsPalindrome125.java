public class IsPalindrome125{
	public static void main(String[] args) {
		String str="";
		System.out.println(str.length());
		System.out.println(new IsPalindrome125().isPalindrome("race a car"));
	}

	//"race a car"
	public boolean isPalindrome(String s) {
		if(s==null||s.length()<=1){
			return true;
		}
		s=s.toLowerCase();
		System.out.println(s);
		int left=0,right=s.length()-1;
		while(left<right){
			char lch=s.charAt(left);
			char rch=s.charAt(right);
            System.out.println(lch+","+rch);
			if(isNumOrChar(lch) && isNumOrChar(rch)){
				//System.out.println(lch+","+rch);
				if(lch==rch){
					left++;
					right--;
				}else{
					return false;
				}
			}else if((!isNumOrChar(lch)) && isNumOrChar(rch)){
				left++;
			}else if(isNumOrChar(lch) && !isNumOrChar(rch)){
				right--;
			}else{
				left++;
				right--;
			}
		}
		return true;
	}

	public boolean isNumOrChar(char ch){
		if((ch>='0' && ch<='9') || (ch>='a' && ch<='z') || (ch>='A' &&  ch<='Z')){
			return true;
		}
		return false;
	}

}