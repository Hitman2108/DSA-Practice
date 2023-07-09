package recursion;

public class Permutation {
	
	public static void main(String[] args) {
		int nums[]= {1,2,3,4};
		recurPermute(0, nums);
	}
	
	public static void recurPermute(int index, int[] nums) {
        if(index == nums.length) {
            // copy the ds to ans
            for(int i = 0;i<nums.length;i++) {
                System.out.print(nums[i]+"");
            }
            System.out.println();
            return; 
        }
        for(int i = index;i<nums.length;i++) {
            swap(i, index, nums); 
            recurPermute(index+1, nums); 
            swap(i, index, nums); 
        }
    }
    public static void swap(int i, int j, int[] nums) {
        int t = nums[i]; 
        nums[i] = nums[j]; 
        nums[j] = t;
    }

}
