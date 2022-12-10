import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class twoSum {
	public static int[] twoSum(int[] nums, int target) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
		int complement = 0;

		// for each number, find its complement
		for (int i = 0; i < nums.length; i++) {
			complement = target - nums[i];

			// if the map contains the complement, grab it and retun results
			if (map.containsKey(complement)) {
				if (i == (int) map.get(complement)) {
					System.out.println(i);
					System.out.println(map.get(complement));
					System.out.println(map);
					continue;
				}
				return new int[] { i, (int) map.get(complement) };
			}
			// add the current number into the hashmap
			map.put(nums[i], i);
		}
		return null;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 2, 3, 3 };
		int target = 6;

		int[] ans = twoSum(nums, target);

		System.out.println(Arrays.toString(ans));

	}
}
