
public class FenwickTree {
	
	//FenwickTree[] is a array representation of FenwickTree
	
	//When we want to update a value at a particular index then we have to change the sum at athat index and 
	//sums at next index till we cross array length
	
	public void updateFenwickTree(int FenwickTree[], int value, int index) {
		while(index<FenwickTree.length) {
			FenwickTree[index]=FenwickTree[index]+value;
			index=getNext(index);
		}
	}
	
	//if we want to get a sum from 0 to index in the Fenwick tree starting from index+1, keep adding value to sum till we 
	//reach 0
	
	public int getSum(int FenwickTree[], int index) {
		index=index+1;				
		int sum=0;
		while(index>0) {
			sum=sum+FenwickTree[index];
			index=getParent(index);
		}
		return sum;
	}
	
	//CreateTree is a function where we can create Fenwick Tree from the input array
	public int[] createTree(int arr[]) {								//arr is a input array
			int[] FenwickTree=new int[arr.length+1];
			for(int i=1;i<=arr.length;i++) {
				updateFenwickTree(FenwickTree,arr[i-1],i);
			}
			return FenwickTree;
	}
	
	/*	To Get Parent
	 * 		1)2's complement of index
	 * 		2)AND of (1) with index
	 * 		3)Substract that from index
	 */
	public int getParent(int index) {
		return index-(index & -index);
	}
	
	/*	To Get Next
	 * 		1)2's complement of index
	 * 		2)AND of (1) with index
	 * 		3)Add it to index
	 */
	public int getNext(int index) {
		return index+(index & -index);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {1,2,3,4,5,6,7};
		FenwickTree ft=new FenwickTree();
		int[] fenwickTree=ft.createTree(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.print(ft.getSum(fenwickTree, i)+" ");
		}

	}

}
