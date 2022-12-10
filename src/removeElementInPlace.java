import java.util.Arrays;

public class removeElementInPlace {
	public static int removeElement(int[] nums, int val) {

		int k = 0;
		for (int num : nums) {
			if (num != val) {
				nums[k] = num;
				k++;
			}
		}
		return k;
	}

	public static void main(String[] args) {

		int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
		int val = 2;

		System.out.println(removeElement(nums, val));

		System.out.println(Arrays.toString(nums));

	}
}
