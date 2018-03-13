
public class KMPSubString {
	
	public int[] computeArray(String pattern) {
		int [] arr=new int[pattern.length()];
		int index =0;
		for(int i=1;i<pattern.length();) {
			if(pattern.charAt(i)==pattern.charAt(index)) {
				arr[i]=index+1;
				index++;
				i++;
			}
			else {
				if(index!=0) {
					index=arr[index-1];
				}
				else {
					arr[i]=0;
					i++;
				}
			}
		}
		return arr;
	}
	
	public boolean KMP(String text,String pattern) {
		int[] arr=computeArray(pattern);
		int i=0;
		int j=0;
		while(i<text.length()&&j<pattern.length()) {
			if(text.charAt(i)==pattern.charAt(j)) {
				i++;
				j++;
			}
			else {
				if(j!=0) {
					j=arr[j-1];
				}
				else {
					i++;
				}
			}
		}
		if(j==pattern.length()) {
			return true;
		}
		else {
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        String str = "abxabcabcaby";
        String pattern = "abcxy";
        KMPSubString ob=new KMPSubString();
        boolean result=ob.KMP(str,pattern);
        System.out.println(result);
	}

}
