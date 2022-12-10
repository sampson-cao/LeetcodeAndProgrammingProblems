import java.util.Arrays;

public class removeDuplicateArrayElementsInPlace {

	public static int removeDuplicates(int[] nums) {

		int k = 0;
		int curInt = -101;

		for (int num : nums) {
			if (curInt == num) {
			} else {
				curInt = num;
				nums[k] = num;
				k++;
			}
		}

		return k;


	}

	public static void main(String[] args) {

		int[] nums = { 1, 1, 2 };

		System.out.println(removeDuplicates(nums));

		System.out.println(Arrays.toString(nums));

	}

}
