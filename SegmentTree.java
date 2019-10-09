import java.util.*;
import java.math.*;
public class SegmentedTree {
	
	int arr[];												// array to store elements of segmented tree
	
	public SegmentedTree(int val[],int n){
		int x=(int)Math.ceil(Math.log(n)/Math.log(2));		//height of segmented tree
		int max_size=2*(int)Math.pow(2, x)-1;				//maximum size of segmented tree
		arr=new int[max_size];
		constructTree(0,n-1,0,val);							//method to construct segmented tree
		
	}
	
	public int getMid(int l,int r) {
		int mis=l+((r-l)/2);
		return mis;											//getting mid to apply divide and conquer method in segmented tree
		
	}
	
	//sl id the initial index of the segment
	//sr is the last index of the segment
	//ci is the value if the current index in the segment array
	//val[] is the array of the given elements
	public int constructTree(int sl,int sr,int ci,int val[]) {
		if(sl==sr) {
			arr[ci]=val[sl];
			return arr[ci];
		}
		int mid=getMid(sl,sr);
		arr[ci]=constructTree(sl,mid,(2*ci)+1,val)+constructTree(mid+1,sr,(2*ci)+2,val);
		return arr[ci];
		
	}
	// ql is the left most index of query
	// qr is right most index of query
	public int getSumV(int sl,int sr,int ql,int qr,int ci) {
		if(ql<=sl&&qr>=sr) {
			return arr[ci];
		}
		else if(sl>qr||sr<ql) {
			return 0;
		}
		else {
			int mid=getMid(sl,sr);
			return getSumV(sl,mid,ql,qr,(2*ci+1))+getSumV(mid+1,sr,ql,qr,(2*ci+2));
		}
		
	}
	public int getSum(int n, int ql,int qr) {
		if(ql<0||qr>=n) {
			System.out.println("Invalid input");
			return -1;
		}
		else {
			return getSumV(0,n-1,ql,qr,0);
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int val[] = {1, 3, 5, 7, 9, 11};
        int n = val.length;
        SegmentedTree  tree = new SegmentedTree(val, n);
        System.out.print("Sum of values in given range = ");
        System.out.println(tree.getSum(n, 1, 3));

	}

}
,//this code is optimised very well i learnt a lot 
