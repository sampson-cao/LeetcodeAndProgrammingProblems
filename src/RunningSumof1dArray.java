
public class RunningSumof1dArray {
	public static int[] runningSum(int[] nums) {

		int[] runningSum = new int[nums.length];

		runningSum[0] = nums[0];

		for (int i = 1; i < nums.length; i++) {
			runningSum[i] = runningSum[i - 1] + nums[i];
		}

		return runningSum;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };

		int[] rs = runningSum(nums);

		for (int a : rs) {
			System.out.println(a);
		}
	}
}
