public class FindDuplicate{
    public static void main(String []args){
       int []arr= {1,2,3,4,5,4};
        System.out.println(findDuplicate(arr));
    }
	public static int findDuplicate(int [] arr) {
		int num=arr.length-1;
		int sum=(num*(num+1))/2;
		int temp=0;
		for(int i=0;i<arr.length;i++){
			temp+=arr[i];
		}
		return temp-sum;

	}
}